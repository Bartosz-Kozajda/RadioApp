package com.bkozajda.radioapp.presentation.discover.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bkozajda.domain.model.Movie
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.common.extensions.inflate
import com.bkozajda.radioapp.databinding.DiscoverItemBinding
import com.bkozajda.radioapp.presentation.discover.presentation.DiscoverItemViewModel
import javax.inject.Inject

class DiscoverMoviesAdapter @Inject constructor(private val itemViewModel: DiscoverItemViewModel)
    : RecyclerView.Adapter<DiscoverMoviesAdapter.ViewHolder>() {

    val data: MutableList<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.discover_item, false)
        return ViewHolder(view, itemViewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View, private val itemViewModel: DiscoverItemViewModel) : RecyclerView.ViewHolder(view) {
        private var binding: DiscoverItemBinding = DiscoverItemBinding.bind(view)

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.viewModel = itemViewModel
        }
    }
}