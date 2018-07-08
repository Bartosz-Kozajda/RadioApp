package com.bkozajda.radioapp.presentation.movieDetail.view

import android.content.Context
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.databinding.FragmentMovieDetailBinding
import com.bkozajda.radioapp.presentation.movieDetail.presentation.MovieDetailViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieDetailFragment : androidx.fragment.app.Fragment() {

    @Inject
    lateinit var movieDetailViewModel: MovieDetailViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

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