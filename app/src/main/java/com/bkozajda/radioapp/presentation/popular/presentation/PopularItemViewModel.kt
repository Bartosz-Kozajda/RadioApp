package com.bkozajda.radioapp.presentation.popular.presentation

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.bkozajda.domain.model.Movie
import com.bkozajda.radioapp.R

const val MOVIE_ID_KEY = "movie_id"
class PopularItemViewModel {
    fun onItemClicked(view: View, movie: Movie) {
        val bundle = bundleOf(Pair(MOVIE_ID_KEY, movie.id))
        Navigation.findNavController(view)
                .navigate(R.id.action_popularMoviesFragment_to_movieDetailFragment, bundle)
    }
}