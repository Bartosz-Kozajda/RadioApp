package com.bkozajda.radioapp.presentation.discover.presentation

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.bkozajda.domain.model.Movie
import com.bkozajda.radioapp.R

private const val MOVIE_ID_KEY = "movie_id"

class MovieItemViewModel : ViewModel() {
    var movie: Movie? = null

    fun onItemClicked(view: View) {
        movie?.let {
            val bundle = Bundle()
            bundle.putInt(MOVIE_ID_KEY, it.id)
            Navigation.findNavController(view).navigate(R.id.action_discoverMoviesFragment_to_movieDetailFragment, bundle)
        }
    }
}