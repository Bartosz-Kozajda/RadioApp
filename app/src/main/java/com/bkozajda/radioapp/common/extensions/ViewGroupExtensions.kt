package com.bkozajda.radioapp.common.extensions

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean): View =
        LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)