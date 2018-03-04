package com.bkozajda.presentation.mapper

import com.bkozajda.domain.model.Movie
import com.bkozajda.presentation.model.MovieViewModel

open class MovieViewModelMapper : Mapper<MovieViewModel, Movie> {
    override fun mapToView(type: Movie): MovieViewModel {
        return MovieViewModel(type.id, type.title, type.voteAverage, type.posterPath)
    }
}