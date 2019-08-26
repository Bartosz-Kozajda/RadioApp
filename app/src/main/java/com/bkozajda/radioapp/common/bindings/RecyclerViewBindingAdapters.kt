package com.bkozajda.radioapp.common.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bkozajda.radioapp.common.views.RecyclerViewAdapter

@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun <T> RecyclerView.bindDataToRecyclerView(data: List<T>?) {
    val adapter = adapter as RecyclerViewAdapter<T>
    data?.let {
        adapter.updateData(it)
    }
}