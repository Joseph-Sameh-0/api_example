package com.example.api_example.core.network

import com.example.api_example.core.data.Album
import retrofit2.http.GET

interface ApiService {
    @GET("albums")
    suspend fun getAlbums(): List<Album>
}
