package com.bkozajda.remote.model

import com.google.gson.annotations.SerializedName

data class DiscoverModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val movies: List<MovieModel>
)