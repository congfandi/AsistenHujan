/*
 * Asisten Hujan
 * MainActivity.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.core

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.LocationServices
import com.thengoding.cuacaku.R
import com.thengoding.cuacaku.databases.DatabaseHelper
import com.thengoding.cuacaku.helpers.SharePreferenceHelper
import com.thengoding.cuacaku.ui.MainFragment

class MainActivity : AppCompatActivity() {

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    listOf(Manifest.permission.ACCESS_FINE_LOCATION).toTypedArray(), 1
                )
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    listOf(Manifest.permission.ACCESS_FINE_LOCATION).toTypedArray(), 1
                )
            }
        }
    }

    private fun currentLocation() {
        val mFusedLocation = LocationServices.getFusedLocationProviderClient(this)
        mFusedLocation.lastLocation.addOnSuccessListener(
            this
        ) { location ->
            Log.e("hasil", "${location.latitude}")
            SharePreferenceHelper(this).saveLocation(
                "${location.latitude}",
                "${location.longitude}"
            )
//            val db = DatabaseHelper().getDatabase().reference
//            db.child("locations").push().setValue(
//                mapOf(
//                    "lat" to location.latitude,
//                    "lon" to location.longitude
//                )
//            ).addOnCompleteListener {
//                Log.e("hasil", "${it.isSuccessful} ${it.exception.toString()}")
//            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    private fun changeUI(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commitNow()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermission()
        currentLocation()
        changeUI(MainFragment.newInstance())
    }
}
