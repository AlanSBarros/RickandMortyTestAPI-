package com.example.applicationtesterm.api

import com.example.applicationtesterm.model.CharactersRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyAPI {

    @GET("character")
    fun listCharacters(
        @Query("page") page: Int = 1
    ): Call<CharactersRequest>

}