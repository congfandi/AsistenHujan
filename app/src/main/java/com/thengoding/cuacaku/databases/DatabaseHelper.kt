/*
 * Cuacaku
 * DatabaseHelper.kt
 * Created by thengoding.com on 2/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.databases

import com.google.firebase.database.FirebaseDatabase

class DatabaseHelper {
    private lateinit var database: FirebaseDatabase

    fun getDatabase(): FirebaseDatabase {
        database = FirebaseDatabase.getInstance()
        database.setPersistenceEnabled(true)
        return database
    }
}