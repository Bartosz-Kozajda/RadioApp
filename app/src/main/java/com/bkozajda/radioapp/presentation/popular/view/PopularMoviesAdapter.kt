package com.bkozajda.radioapp.presentation.popular.view

import android.view.ViewGroup
import com.bkozajda.domain.model.Movie
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.common.extensions.inflate
import com.bkozajda.radioapp.common.views.BindingViewHolder
import com.bkozajda.radioapp.common.views.RecyclerViewAdapter
import com.bkozajda.radioapp.databinding.PopularItemBinding
import com.bkozajda.radioapp.presentation.popular.presentation.PopularItemViewModel

class PopularMoviesAdapter(private val itemViewModel: PopularItemViewModel) : RecyclerViewAdapter<Movie>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BindingViewHolder<Movie> {
        val view = parent.inflate(R.layout.popular_item, false)
        return BindingViewHolder(PopularItemBinding.bind(view), itemViewModel)
    }
}