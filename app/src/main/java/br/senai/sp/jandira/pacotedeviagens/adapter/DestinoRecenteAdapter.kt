package br.senai.sp.jandira.pacotedeviagens.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.pacotedeviagens.model.DestinosRecentes

class DestinoRecenteAdapter(
    val listRecentes: List<DestinosRecentes>,
    val context: Context) : RecyclerView.Adapter<DestinoRecenteAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        TODO("Not yet implemented")
    }

    //inner class
    class Holder(view: View):RecyclerView.ViewHolder(view) {

    }
}