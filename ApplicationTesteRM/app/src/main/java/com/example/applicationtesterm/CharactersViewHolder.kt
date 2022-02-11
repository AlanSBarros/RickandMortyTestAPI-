package com.example.applicationtesterm

import android.content.DialogInterface
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtesterm.databinding.ItemPersonagemBinding
import com.example.applicationtesterm.model.Character
import com.squareup.picasso.Picasso
import org.koin.java.KoinJavaComponent.inject

interface onSelectCharacterListener {
    fun onSelectCharacter(character: Character)
}

class CharactersViewHolder(val binding: ItemPersonagemBinding) : RecyclerView.ViewHolder(binding.root) {

    val imageLoader: Picasso by inject(Picasso::class.java)

    fun setCharacter(character: Character, onClickListener: onSelectCharacterListener?) {
        imageLoader.load(character.image).into(binding.charImage);
        binding.charSpecies.text = character.species
        binding.charName.text = character.name
        binding.root.setOnClickListener { onClickListener?.onSelectCharacter(character) }
    }

}