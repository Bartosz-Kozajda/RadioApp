package com.bkozajda.radioapp.common.bindings

import androidx.databinding.BindingAdapter
import android.view.View
import android.view.View.VISIBLE
import android.view.View.GONE

@BindingAdapter("isVisible")
fun View.isVisible(isVisible: Boolean) {
    visibility = if (isVisible) VISIBLE else GONE
}