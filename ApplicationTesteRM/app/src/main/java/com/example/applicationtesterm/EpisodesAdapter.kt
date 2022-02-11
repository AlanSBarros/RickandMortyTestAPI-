package com.example.applicationtesterm

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtesterm.databinding.ItemEpisodioBinding
import com.example.applicationtesterm.model.Episodio

class EpisodesAdapter(
    val layoutInflater: LayoutInflater
): RecyclerView.Adapter<EpisodesViewHolder>() {

    val listagem: ArrayList<Episodio> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        val binding = ItemEpisodioBinding.inflate(layoutInflater, parent, false)
        return EpisodesViewHolder(binding).also {
            Log.d("recycle", "AdapterCreateNew vha: $it")
        }
    }

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        Log.d("recycle", "AdapterBindView position: $position vha: $holder")
        holder.setEpisode(listagem[position])
    }

    override fun getItemCount(): Int {
        Log.d("recycle", "AdapterGetSize")
        return listagem.size
    }

    fun addEpisodes(itens: List<Episodio>){
        listagem.addAll(itens)
        notifyDataSetChanged()
    }
}