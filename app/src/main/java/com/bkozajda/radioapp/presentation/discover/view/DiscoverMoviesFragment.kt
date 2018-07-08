package com.bkozajda.radioapp.presentation.discover.view

import android.content.Context
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.databinding.FragmentDiscoverMoviesBinding
import com.bkozajda.radioapp.presentation.discover.presentation.DiscoverMoviesViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_discover_movies.*
import javax.inject.Inject

class DiscoverMoviesFragment : Fragment() {

    @Inject
    lateinit var discoverMoviesViewModel: DiscoverMoviesViewModel

    @Inject
    lateinit var adapter: DiscoverMoviesAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentDiscoverMoviesBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_discover_movies, container, false)
        binding.let {
            it.viewModel = discoverMoviesViewModel
            it.adapter = adapter
            it.setLifecycleOwner(this)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
    }

    private fun setupList() {
        recycler_view.layoutManager = GridLayoutManager(context, 2)
        recycler_view.adapter = adapter
    }
}