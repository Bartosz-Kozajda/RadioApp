package com.bkozajda.radioapp.presentation.popular.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.common.extensions.observeLifecycleIn
import com.bkozajda.radioapp.databinding.FragmentPopularMoviesBinding
import com.bkozajda.radioapp.presentation.popular.presentation.PopularMoviesViewModel
import kotlinx.android.synthetic.main.fragment_popular_movies.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val GRID_COLUMNS_COUNT = 2

class PopularMoviesFragment : Fragment() {

    private val popularMoviesViewModel: PopularMoviesViewModel by viewModel()
    private val popularMoviesAdapter: PopularMoviesAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeLifecycleIn(popularMoviesViewModel)
        val binding: FragmentPopularMoviesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_popular_movies, container, false)
        binding.let {
            it.viewModel = popularMoviesViewModel
            it.lifecycleOwner = this
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
    }

    private fun setupList() {
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, GRID_COLUMNS_COUNT)
            adapter = popularMoviesAdapter
        }
    }
}