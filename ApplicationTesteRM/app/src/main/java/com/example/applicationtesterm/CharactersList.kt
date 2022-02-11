package com.example.applicationtesterm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtesterm.CharacterDetails.Companion.EXTRA_CHARACTER
import com.example.applicationtesterm.api.RickMortyAPI
import kotlinx.coroutines.CoroutineScope
import com.example.applicationtesterm.databinding.ListagemBinding
import com.example.applicationtesterm.model.Character
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersList : Activity(), onSelectCharacterListener {

    var page = 1
    var carregando = false
    val serviceAPI: RickMortyAPI by inject(RickMortyAPI::class.java)

    lateinit var binding: ListagemBinding
    lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListagemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
        carregarPersonagens()
    }

    private fun initList() {
        Log.d("recycle", "initList")
        adapter = CharactersAdapter(layoutInflater, this)
        binding.charsList.adapter = adapter
        binding.charsList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (!recyclerView.canScrollVertically(1) && !carregando) {
                carregarPersonagens()
                Log.d("recycle", "LoadMoreItems")
            }
        }
        })
    }

    private fun carregarPersonagens() {
        binding.progressBar.visibility = View.VISIBLE
        carregando = true
        GlobalScope.launch(IO) {
            val call = serviceAPI.listCharacters(page).execute()
            Log.d("", call.toString())

            val list = call.body()?.results

            withContext(Main) {
                list?.let {
                    page++
                    adapter.addCharacters(it)
                }
                carregando = false
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.progressBar.visibility = View.GONE
                },50)

            }
        }
    }

    override fun onSelectCharacter(character: Character) {

        startActivity(Intent(this, CharacterDetails::class.java).apply {
            putExtra(EXTRA_CHARACTER, character)
        })
    }
}