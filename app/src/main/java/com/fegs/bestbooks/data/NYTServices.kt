package com.fegs.bestbooks.data

import com.fegs.bestbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {
    @GET("lists.json")
    fun getBooks(
        @Query("api-key")apiKey: String = "mjhTGY2GCT5HArFOuJVlDuzy6idfvDGo",
        @Query("list")list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}