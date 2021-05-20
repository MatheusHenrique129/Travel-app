package br.senai.sp.jandira.pacotedeviagens.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.pacotedeviagens.R
import br.senai.sp.jandira.pacotedeviagens.model.DestinosRecentes
import br.senai.sp.jandira.pacotedeviagens.adapter.DestinoRecenteAdapter
import br.senai.sp.jandira.pacotedeviagens.api.DestinosRecentesCall
import br.senai.sp.jandira.pacotedeviagens.api.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var rvDestinosRecentes: RecyclerView
    lateinit var adapterDestinosRecentes: DestinoRecenteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDestinosRecentes = findViewById(R.id.rv_destinos_recentes)

        rvDestinosRecentes.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL, false)

         adapterDestinosRecentes =
            DestinoRecenteAdapter(this)

        rvDestinosRecentes.adapter = adapterDestinosRecentes

        carregarListaDestinosRecentes()

    }

    private fun carregarListaDestinosRecentes() {

        var destinosRecentes: List<DestinosRecentes> = listOf<DestinosRecentes>()

        val retrofit = RetrofitApi.getRetrofit()
        val destinosRecentesCall = retrofit.create(DestinosRecentesCall::class.java)

        val call = destinosRecentesCall.getDestinosRecentes()

        call.enqueue(object : Callback<List<DestinosRecentes>> {

            override fun onFailure(call: Call<List<DestinosRecentes>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ops! falha na conexão.", Toast.LENGTH_SHORT).show()
                Log.e("ERRO_CONEXAO", t.message.toString())
            }

            override fun onResponse(call: Call<List<DestinosRecentes>>, response: Response<List<DestinosRecentes>>) {
                destinosRecentes = response.body()!! //Double BANG!!
                adapterDestinosRecentes.updateListaRecente(destinosRecentes)
            }
        })
    }
}