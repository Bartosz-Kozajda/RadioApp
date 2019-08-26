package com.bkozajda.remote.common

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

val moshi = Moshi.Builder().build()

inline fun <reified T> fromJson(path: String): T {
    val jsonAdapter: JsonAdapter<T> = moshi.adapter(T::class.java)
    val json = readJson(path)
    return jsonAdapter.fromJson(json)!!
}

fun readJson(path: String): String {
    val uri = Paths.get(ClassLoader.getSystemClassLoader().getResource(path).toURI())
    return Files
        .lines(uri)
        .parallel()
        .collect(Collectors.joining())
}