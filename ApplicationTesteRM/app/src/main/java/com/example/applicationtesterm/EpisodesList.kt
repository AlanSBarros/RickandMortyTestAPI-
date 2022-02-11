package com.example.applicationtesterm

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtesterm.api.EpisodeAPI
import com.example.applicationtesterm.databinding.ListagemEpisodioBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject

class EpisodesList : Activity() {

    var page = 1
    var carregando = false
    val serviceAPI: EpisodeAPI by inject(EpisodeAPI::class.java)

    lateinit var binding: ListagemEpisodioBinding
    lateinit var adapter: EpisodesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListagemEpisodioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
        carregarEpisodios()


    }

    private fun initList() {
        Log.d("recycle", "initList")
        adapter = EpisodesAdapter(layoutInflater)
        binding.epList.adapter = adapter
        binding.epList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && !carregando) {
                    carregarEpisodios()
                    Log.d("recycle", "LoadMoreItems")
                }
            }
        })
    }

    private fun carregarEpisodios() {
        binding.progressBar.visibility = View.VISIBLE
        carregando = true
        GlobalScope.launch(Dispatchers.IO) {
            val call = serviceAPI.listEpisodes(page).execute()
            Log.d("", call.toString())

            val list = call.body()?.results

            withContext(Dispatchers.Main) {
                list?.let {
                    page++
                    adapter.addEpisodes(it)
                }
                carregando = false
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.progressBar.visibility = View.GONE
                },50)

            }
        }
    }
}