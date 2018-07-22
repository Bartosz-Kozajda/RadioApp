package com.bkozajda.radioapp.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bkozajda.remote.model.MovieModel

@Database(entities = [(MovieModel::class)], version = 1)
abstract class AppDatabase : RoomDatabase()