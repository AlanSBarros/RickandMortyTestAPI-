package com.example.applicationtesterm.api

import com.example.applicationtesterm.model.EpisodesRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeAPI {

    @GET("episode")
    fun listEpisodes(
        @Query("page") page: Int = 1
    ) : Call<EpisodesRequest>
}