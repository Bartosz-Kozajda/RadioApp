package com.bkozajda.presentation.mapper

interface Mapper<out V, in D> {
    fun mapToView(type: D): V
}