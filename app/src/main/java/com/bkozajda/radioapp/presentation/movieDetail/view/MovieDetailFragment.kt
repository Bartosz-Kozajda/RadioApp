package com.bkozajda.radioapp.presentation.movieDetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.common.extensions.observeLifecycleIn
import com.bkozajda.radioapp.databinding.FragmentMovieDetailBinding
import com.bkozajda.radioapp.presentation.discover.presentation.MOVIE_ID_KEY
import com.bkozajda.radioapp.presentation.movieDetail.presentation.MovieDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : Fragment() {

    private val movieDetailViewModel: MovieDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieDetailViewModel.movieId = movieId()
        observeLifecycleIn(movieDetailViewModel)
        val binding: FragmentMovieDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false)
        binding.let {
            it.viewModel = movieDetailViewModel
            it.lifecycleOwner = this
        }
        return binding.root
    }

    private fun movieId(): Int =
        arguments?.getInt(MOVIE_ID_KEY)!!
}