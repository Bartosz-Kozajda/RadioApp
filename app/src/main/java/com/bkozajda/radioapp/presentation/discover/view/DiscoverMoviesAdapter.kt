package com.bkozajda.radioapp.presentation.discover.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bkozajda.domain.model.Movie
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.common.extensions.inflate
import com.bkozajda.radioapp.databinding.DiscoverItemBinding

class DiscoverMoviesAdapter : RecyclerView.Adapter<DiscoverMoviesAdapter.ViewHolder>() {

    val data: MutableList<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.discover_item, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: DiscoverItemBinding = DiscoverItemBinding.bind(view)
        fun bind(movie: Movie) {
            binding.movie = movie
        }
    }
}