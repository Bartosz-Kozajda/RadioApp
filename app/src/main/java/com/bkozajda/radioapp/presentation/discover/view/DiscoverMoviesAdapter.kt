package com.bkozajda.radioapp.presentation.discover.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bkozajda.domain.model.Movie
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.common.extensions.inflate
import com.bkozajda.radioapp.databinding.DiscoverItemBinding
import com.bkozajda.radioapp.presentation.discover.presentation.MovieItemViewModel

class DiscoverMoviesAdapter(private val movieItemViewModel: MovieItemViewModel)
    : RecyclerView.Adapter<DiscoverMoviesAdapter.ViewHolder>() {

    val data: MutableList<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.discover_item, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], movieItemViewModel)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: DiscoverItemBinding = DiscoverItemBinding.bind(view)
        fun bind(movie: Movie, viewModel: MovieItemViewModel) {
            viewModel.movie = movie
            binding.movie = movie
            binding.viewModel = viewModel
        }
    }
}