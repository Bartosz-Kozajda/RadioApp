package com.bkozajda.radioapp.presentation.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bkozajda.radioapp.R
import com.bkozajda.radioapp.databinding.ActivityMainBinding
import com.bkozajda.radioapp.presentation.discover.DiscoverMoviesViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var discoverMoviesViewModel: DiscoverMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val binding: ActivityMainBinding? = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.let {
            it.viewModel = discoverMoviesViewModel
            it.setLifecycleOwner(this)
        }
        discoverMoviesViewModel.collectMovies()
    }
}
