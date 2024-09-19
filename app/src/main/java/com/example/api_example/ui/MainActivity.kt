package com.example.api_example.ui


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_example.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var albumViewModel: AlbumViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        albumViewModel = ViewModelProvider(this)[AlbumViewModel::class.java]
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val myAdapter = AlbumAdapter()
        binding.recyclerView.adapter = myAdapter

        albumViewModel.albums.observe(this, Observer(myAdapter::submitList))
        albumViewModel.fetchAlbums()

    }
}
