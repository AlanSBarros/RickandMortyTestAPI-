package com.example.applicationtesterm.model

import com.google.gson.annotations.SerializedName

data class CharactersRequest(
    @SerializedName("info") val info: Pagination,
    @SerializedName ("results") val results: List<Character>
)