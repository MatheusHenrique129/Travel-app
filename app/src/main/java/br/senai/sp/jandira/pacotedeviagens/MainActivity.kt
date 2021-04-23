package br.senai.sp.jandira.pacotedeviagens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.pacotedeviagens.adapter.DestinoRecenteAdapter
import br.senai.sp.jandira.pacotedeviagens.model.DestinosRecentes

class MainActivity : AppCompatActivity() {

    lateinit var rvDestinosRecentes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDestinosRecentes = findViewById(R.id.rv_destinos_recentes)

        rvDestinosRecentes.layoutManager =
            LinearLayoutManager(
            this,
                    LinearLayoutManager.HORIZONTAL,
                    false)

        val adapterDestinosRecentes =
            DestinoRecenteAdapter(setListaDestinosRecentes(), this)

        rvDestinosRecentes.adapter = adapterDestinosRecentes
    }

    private fun setListaDestinosRecentes() : List<DestinosRecentes> {

        val lista = listOf(
            DestinosRecentes("Rio de Janeiro", "Brasil", "R$150"),
            DestinosRecentes("Rio de Janeiro", "Brasil", "R$150"),
            DestinosRecentes("Rio de Janeiro", "Brasil", "R$150"),
            DestinosRecentes("Rio de Janeiro", "Brasil", "R$150"),
            DestinosRecentes("Rio de Janeiro", "Brasil", "R$150"))

        return lista
    }
}