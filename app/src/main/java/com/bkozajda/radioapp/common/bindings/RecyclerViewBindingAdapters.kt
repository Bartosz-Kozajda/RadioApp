package com.bkozajda.radioapp.common.bindings

import androidx.lifecycle.MutableLiveData
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("adapterData", "modelData")
fun <T> RecyclerView.bindDataToRecyclerView(adapterData: MutableList<T>, modelData: MutableLiveData<List<T>>) {
    modelData.value?.let {
        if (adapterData == it) {
            return
        }
        adapterData.addAll(it)
        adapter?.notifyItemInserted(adapterData.size - 1)
    }
}