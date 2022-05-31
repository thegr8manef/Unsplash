package com.example.mobelite_community.model.repository.remote

import com.example.mobelite_community.BuildConfig
import com.example.mobelite_community.model.entity.Photo
import com.example.mobelite_community.model.entity.UnsplashResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface UnsplachService {
    @GET("search/photos/")
    fun getAllData(
        @Query("page") page: Int,
        @Query("per_page") pageLimit: Int,
        @Query("order_by") order: String,
        @Query("query") query: String
    ) :  Call<UnsplashResponse>
}