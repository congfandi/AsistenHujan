/*
 * Cuacaku
 * RealmApplication.kt
 * Created by thengoding.com on 1/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.realms

import android.app.Application
import com.thengoding.cuacaku.helpers.DATABASE_NAME
import io.realm.Realm
import io.realm.RealmConfiguration


class RealmApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name(DATABASE_NAME).build()
        Realm.setDefaultConfiguration(config)
    }
}