/*
 * Cuacaku
 * SplashActivity.kt
 * Created by thengoding.com on 1/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thengoding.cuacaku.R
import com.thengoding.cuacaku.ui.SplashFragment

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SplashFragment.newInstance())
                .commitNow()
        }
    }

}
