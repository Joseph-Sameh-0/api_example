package com.example.api_example.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_example.core.data.Album
import com.example.api_example.core.network.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val albumRepository: AlbumRepository) :
    ViewModel() {
    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    init {
        fetchAlbums()
    }

    fun fetchAlbums() {
        viewModelScope.launch {
            val response = albumRepository.getAlbums()
            _albums.postValue(response)
        }

    }
}