package com.bkozajda.radioapp.presentation.discover

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.databinding.FragmentDiscoverMoviesBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DiscoverMoviesFragment : Fragment() {

    @Inject
    lateinit var discoverMoviesViewModel: DiscoverMoviesViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentDiscoverMoviesBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_discover_movies, container, false)
        binding.let {
            it.viewModel = discoverMoviesViewModel
            it.setLifecycleOwner(this)
        }
        return binding.root
    }
}