package com.bkozajda.radioapp.common.views

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bkozajda.radioapp.BR
import com.bkozajda.radioapp.common.viewmodels.ItemViewModel

class BindingViewHolder<T>(
    private val binding: ViewDataBinding,
    private val itemViewModel: ItemViewModel? = null
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: T) {
        binding.setVariable(BR.item, item)
        itemViewModel?.let {
            binding.setVariable(BR.viewModel, it)
        }
        binding.executePendingBindings()
    }
}