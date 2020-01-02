/*
 * Cuacaku
 * Extention.kt
 * Created by thengoding.com on 2/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.extentions

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide

fun ImageView.setImage(icon: String) {
    Glide.with(context).load("https://www.weatherbit.io/static/img/icons/$icon.png").into(this)
}

fun TextView.hide() {
    visibility = View.INVISIBLE
}

fun TextView.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.INVISIBLE
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

