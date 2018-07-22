package com.bkozajda.radioapp.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bkozajda.remote.model.MovieModel

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    fun movies(): List<MovieModel>

    @Insert
    fun insertAll(movies: List<MovieModel>)
}