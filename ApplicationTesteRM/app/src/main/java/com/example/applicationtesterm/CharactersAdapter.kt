package com.example.applicationtesterm

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtesterm.databinding.ItemPersonagemBinding
import com.example.applicationtesterm.model.Character

class CharactersAdapter(
    val layoutInflater: LayoutInflater,
    val onItemClickListener: onSelectCharacterListener
): RecyclerView.Adapter<CharactersViewHolder>() {

    val listagem: ArrayList<Character> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val binding = ItemPersonagemBinding.inflate(layoutInflater, parent, false)
        return CharactersViewHolder(binding).also {
            Log.d("recycle", "AdapterCreateNew vha: $it")
        }
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        Log.d("recycle", "AdapterBindView position: $position vha: $holder")
        holder.setCharacter(listagem[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        Log.d("recycle", "AdapterGetSize")
        return listagem.size
    }

        fun addCharacters(itens: List<Character>){
            listagem.addAll(itens)
            notifyDataSetChanged()
        }
    }



