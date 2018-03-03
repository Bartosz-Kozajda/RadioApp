package com.bkozajda.remote.mapper

interface EntityMapper<in M, out E> {
    fun mapFromRemote(type: M): E
}