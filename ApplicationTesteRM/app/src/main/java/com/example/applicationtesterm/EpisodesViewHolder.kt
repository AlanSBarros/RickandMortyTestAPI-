package com.example.applicationtesterm

import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtesterm.databinding.ItemEpisodioBinding
import com.example.applicationtesterm.model.Episodio

interface onSelectEpisodeListener{
    fun onSelectEpisode(episodio: Episodio)
}

class EpisodesViewHolder (val binding: ItemEpisodioBinding) : RecyclerView.ViewHolder(binding.root){
    fun setEpisode(episodio: Episodio){
        binding.epName.text = episodio.name
        binding.epEpisode.text = episodio.episode
        binding.epDate.text = episodio.air_date
    }
}