package com.example.api_example.ui


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.api_example.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var albumViewModel: AlbumViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        albumViewModel = ViewModelProvider(this)[AlbumViewModel::class.java]
        setContentView(binding.root)

        albumViewModel.albums.observe(this, Observer {
            for (item in it) {
                Log.i("test", item.id.toString())
                Log.i("test", item.userId.toString())
                Log.i("test", item.title)
            }
        })
    }
}
