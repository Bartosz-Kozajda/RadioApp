package com.bkozajda.radioapp.presentation.movieDetail.presentation

sealed class MovieDetailViewModelState {
    class Empty : MovieDetailViewModelState()
    class Loaded : MovieDetailViewModelState()
}