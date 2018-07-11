package com.bkozajda.radioapp.presentation.movieDetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.databinding.FragmentMovieDetailBinding
import com.bkozajda.radioapp.presentation.movieDetail.presentation.MovieDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : Fragment() {

    val movieDetailViewModel: MovieDetailViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentMovieDetailBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false)
        binding.let {
            it.viewModel = movieDetailViewModel
            it.setLifecycleOwner(this)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetailViewModel.fetchMovie(arguments?.getInt("movie_id") ?: 0)
    }
}