/*
 * Cuacaku
 * SplashViewModel.kt
 * Created by thengoding.com on 1/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.viewmodels

import android.content.Context
import android.content.Intent
import android.os.Handler
import androidx.lifecycle.ViewModel
import com.thengoding.cuacaku.core.MainActivity

class SplashViewModel : ViewModel() {

    fun loadNewPage(context: Context, result: () -> Unit) {
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
            result()
        }, 3000)
    }
}
