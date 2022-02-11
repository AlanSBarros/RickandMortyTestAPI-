package com.example.applicationtesterm.koinmodule

import com.example.applicationtesterm.api.EpisodeAPI
import com.example.applicationtesterm.api.RickMortyAPI
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val serverModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<RickMortyAPI> {
        get<Retrofit>().create(RickMortyAPI::class.java)
    }

    single<EpisodeAPI> {
        get<Retrofit>().create(EpisodeAPI::class.java)
    }
}