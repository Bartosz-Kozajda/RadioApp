package com.bkozajda.radioapp.presentation.discover.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.common.extensions.observeLifecycleIn
import com.bkozajda.radioapp.databinding.FragmentDiscoverMoviesBinding
import com.bkozajda.radioapp.presentation.discover.presentation.DiscoverMoviesViewModel
import kotlinx.android.synthetic.main.fragment_discover_movies.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val GRID_COLUMNS_COUNT = 2

class DiscoverMoviesFragment : Fragment() {

    private val discoverMoviesViewModel: DiscoverMoviesViewModel by viewModel()
    private val discoverMoviesAdapter: DiscoverMoviesAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeLifecycleIn(discoverMoviesViewModel)
        val binding: FragmentDiscoverMoviesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_discover_movies, container, false)
        binding.let {
            it.viewModel = discoverMoviesViewModel
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
            adapter = discoverMoviesAdapter
        }
    }
}