package com.example.tvshowapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tvshowapp.databinding.TvShowLayoutAdapterBinding
import com.example.tvshowapp.model.TvShowItem

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvViewHolder>() {

    inner class TvViewHolder(val binding: TvShowLayoutAdapterBinding):RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<TvShowItem>() {
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)

    fun submitList(list: List<TvShowItem>) = differ.submitList(list)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        return TvViewHolder(
            TvShowLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ))
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val currentTvShow = differ.currentList[position]
        holder.binding.apply {
            textView.text = currentTvShow.name
            imageView.load(currentTvShow.image.original) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}