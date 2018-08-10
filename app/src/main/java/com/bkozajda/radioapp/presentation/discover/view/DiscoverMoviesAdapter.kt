package com.bkozajda.radioapp.presentation.discover.view

import android.view.ViewGroup
import com.bkozajda.domain.model.Movie
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.common.extensions.inflate
import com.bkozajda.radioapp.common.views.BindingViewHolder
import com.bkozajda.radioapp.common.views.RecyclerViewAdapter
import com.bkozajda.radioapp.databinding.DiscoverItemBinding
import com.bkozajda.radioapp.presentation.discover.presentation.DiscoverItemViewModel

class DiscoverMoviesAdapter(private val itemViewModel: DiscoverItemViewModel) : RecyclerViewAdapter<Movie>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BindingViewHolder<Movie> {
        val view = parent.inflate(R.layout.discover_item, false)
        return BindingViewHolder(DiscoverItemBinding.bind(view), itemViewModel)
    }
}