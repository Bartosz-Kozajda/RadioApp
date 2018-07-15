package com.bkozajda.radioapp.presentation.main.di

import com.bkozajda.radioapp.presentation.main.presentation.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val MainActivityModule = module {
    viewModel { MainActivityViewModel() }
}