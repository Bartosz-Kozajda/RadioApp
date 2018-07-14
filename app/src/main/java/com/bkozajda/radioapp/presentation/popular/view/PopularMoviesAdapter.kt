package com.bkozajda.radioapp.presentation.popular.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bkozajda.domain.model.Movie
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.common.extensions.inflate
import com.bkozajda.radioapp.databinding.PopularItemBinding
import com.bkozajda.radioapp.presentation.popular.presentation.PopularItemViewModel

class PopularMoviesAdapter(private val itemViewModel: PopularItemViewModel)
    : RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>() {

    val data: MutableList<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.popular_item, false)
        return ViewHolder(view, itemViewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View, private val itemViewModel: PopularItemViewModel) : RecyclerView.ViewHolder(view) {
        private var binding: PopularItemBinding = PopularItemBinding.bind(view)

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.viewModel = itemViewModel
        }
    }
}