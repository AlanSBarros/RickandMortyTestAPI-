package com.example.applicationtesterm

import android.app.Activity
import android.os.Bundle
import com.example.applicationtesterm.R
import androidx.cardview.widget.CardView
import android.content.Intent
import android.view.View
import com.bumptech.glide.Glide
import com.example.applicationtesterm.CharactersList
import com.example.applicationtesterm.EpisodesList
import com.example.applicationtesterm.databinding.SelectionScreenBinding
import java.lang.System.load

class SelectionActivity : Activity() {

    private lateinit var binding: SelectionScreenBinding

    companion object{
        const val portalGif = "https://media0.giphy.com/media/3o7aD2d7hy9ktXNDP2/giphy.gif"
        const val selectionGif = "https://64.media.tumblr.com/51015ec638a516f7f7d353ca198a5091/tumblr_pdbo9wBAe11xd0gvgo1_1280.gifv"
        const val characterGif = "https://thumbs.gfycat.com/AlarmedInsistentGrayreefshark-size_restricted.gif"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selection_screen)


        binding = SelectionScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.cardPersonagens.setOnClickListener {
            openCharactersActivity()
        }
        binding.cardEpisodios.setOnClickListener {
            openEpisodesActivity()
        }



        Glide.with(this).load(selectionGif).into(binding.categoriaImage)
        Glide.with(this).load(characterGif).circleCrop().into(binding.imgPersonagens)
        Glide.with(this).load(portalGif).into(binding.imgEpisodios)
    }

    fun openCharactersActivity() {
        val intent = Intent(this, CharactersList::class.java)
        startActivity(intent)
    }

    fun openEpisodesActivity() {
        val intent = Intent(this, EpisodesList::class.java)
        startActivity(intent)
    }
}