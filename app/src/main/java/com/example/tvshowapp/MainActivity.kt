package com.example.tvshowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvshowapp.adapter.TvShowAdapter
import com.example.tvshowapp.databinding.ActivityMainBinding
import com.example.tvshowapp.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var adapter: TvShowAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        initShowAdapter()
        initEpisodesAdapter()

        viewModel.responseTvShow.observe(this, Observer {
            it?.let {
                adapter.differ.submitList(it)
            }
        })
        viewModel.responseTvShow.observe(this, Observer {
            it?.let {
                adapter.differ.submitList(it)
            }
        })
        viewModel.responseTvShow.observe(this, Observer {
            it?.let {
                adapter.differ.submitList(it)
            }
        })
    }


    private fun initShowAdapter() {
        adapter = TvShowAdapter()
        binding.recyclerView.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
    }

    private fun initEpisodesAdapter() {
        adapter = TvShowAdapter()
        binding.rvEpisodes.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
    }
}