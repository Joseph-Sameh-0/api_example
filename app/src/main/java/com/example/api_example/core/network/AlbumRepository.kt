package com.example.api_example.core.network

import com.example.api_example.core.data.Album
import javax.inject.Inject

class AlbumRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAlbums(): List<Album> {
        return apiService.getAlbums()
    }
}
