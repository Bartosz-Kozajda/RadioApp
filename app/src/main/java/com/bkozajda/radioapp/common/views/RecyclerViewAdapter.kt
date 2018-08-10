package com.bkozajda.radioapp.common.views

import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewAdapter<T> :
        RecyclerView.Adapter<BindingViewHolder<T>>() {

    private val data: MutableList<T> = mutableListOf()

    override fun onBindViewHolder(holder: BindingViewHolder<T>, position: Int) {
        holder.bind(data[position])
    }

    fun updateData(newData: List<T>?) {
        newData?.let {
            data.clear()
            data.addAll(it)
            notifyItemInserted(it.size - 1)
        }
    }

    override fun getItemCount() = data.size
}