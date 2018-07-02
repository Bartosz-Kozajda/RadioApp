package com.bkozajda.radioapp.common.bindings

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

@BindingAdapter("adapterData", "modelData")
fun <T> RecyclerView.bindDataToRecyclerView(adapterData: MutableList<T>, modelData: MutableLiveData<List<T>>) {
    modelData.value?.let {
        adapterData.addAll(it)
        adapter.notifyItemInserted(adapterData.size - 1)
    }
}