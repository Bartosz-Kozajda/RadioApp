package com.bkozajda.radioapp.common.bindings

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun ImageView.loadImageFromUrl(url: String?) {
    url?.let {
        Glide.with(context)
                .load(url)
                .into(this)
    }
}