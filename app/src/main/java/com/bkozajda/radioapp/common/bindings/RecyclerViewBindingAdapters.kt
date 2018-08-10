package com.bkozajda.radioapp.common.bindings

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bkozajda.radioapp.common.views.RecyclerViewAdapter

@BindingAdapter("adapter", "data")
fun <T> RecyclerView.bindDataToRecyclerView(adapter: RecyclerViewAdapter<T>, data: MutableLiveData<List<T>>) {
    data.value?.let {
        adapter.updateData(it)
    }
}