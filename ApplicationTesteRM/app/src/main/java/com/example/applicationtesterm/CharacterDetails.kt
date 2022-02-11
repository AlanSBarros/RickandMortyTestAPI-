package com.example.applicationtesterm

import android.app.Activity
import android.os.Bundle
import com.example.applicationtesterm.databinding.DetalhesPersonagemBinding
import com.example.applicationtesterm.model.Character
import com.squareup.picasso.Picasso
import org.koin.java.KoinJavaComponent.inject

class CharacterDetails : Activity() {

    private lateinit var binding: DetalhesPersonagemBinding
    private val imageLoader: Picasso by inject(Picasso::class.java)

    companion object {
        const val EXTRA_CHARACTER = "extra_character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val character = intent.extras?.getParcelable<Character>(EXTRA_CHARACTER)
        if (character == null){
            finish()
            return
        }

        binding = DetalhesPersonagemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            imageLoader.load(character.image).into(charImage)
            textName.text = character.name
            textSpecie.text = character.species
            textStatus.text = character.status
            textGender.text = character.gender
            textOrigin.text = character.origin.name
            textLocal.text = character.location.name

        }
    }
}