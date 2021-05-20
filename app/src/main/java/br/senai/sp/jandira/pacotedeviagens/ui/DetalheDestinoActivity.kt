package br.senai.sp.jandira.pacotedeviagens.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.senai.sp.jandira.pacotedeviagens.R
import br.senai.sp.jandira.pacotedeviagens.model.DestinosRecentes
import com.bumptech.glide.Glide

class DetalheDestinoActivity : AppCompatActivity() {

    lateinit var ivFotoDestino: ImageView
    lateinit var tvLocal: TextView
    lateinit var tvValor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_destino)

        ivFotoDestino = findViewById(R.id.iv_destino)
        tvLocal = findViewById(R.id.tv_local)
        tvValor = findViewById(R.id.tv_valor)

        val destinoRecente: DestinosRecentes =
            intent.getSerializableExtra("destino") as DestinosRecentes

        tvLocal.text = destinoRecente.nome
        tvValor.text = destinoRecente.valor.toString()

        Glide.with(this).load(destinoRecente.urlFoto).into(ivFotoDestino)

    }
}