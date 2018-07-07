package com.bkozajda.radioapp.presentation.movieDetail.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MovieDetailViewModel : ViewModel() {
    var title = MutableLiveData<String>()
}