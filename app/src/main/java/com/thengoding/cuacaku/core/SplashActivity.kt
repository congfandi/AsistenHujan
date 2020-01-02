/*
 * Cuacaku
 * SplashActivity.kt
 * Created by thengoding.com on 2/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.core

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.location.LocationServices
import com.thengoding.cuacaku.R
import com.thengoding.cuacaku.extentions.hide
import com.thengoding.cuacaku.extentions.show
import com.thengoding.cuacaku.helpers.SharePreferenceHelper
import com.thengoding.cuacaku.viewmodels.SplashViewModel
import kotlinx.android.synthetic.main.splash_activity.*

class SplashActivity : AppCompatActivity() {
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

    private fun getLocation() {
        val mFusedLocation = LocationServices.getFusedLocationProviderClient(this)
        mFusedLocation.lastLocation.addOnSuccessListener(
            this
        ) { location ->
            preferenceHelper.saveLocation(
                "${location.latitude}",
                "${location.longitude}"
            )
            splashViewModel.addLocation(
                preferenceHelper.getLocation()[0],
                preferenceHelper.getLocation()[1]
            )
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
                        getLocation()
                    }
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                    finish()
                }
                return
            }
        }
    }


    private lateinit var splashViewModel: SplashViewModel
    private lateinit var preferenceHelper: SharePreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        preferenceHelper = SharePreferenceHelper(this)
        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        if (preferenceHelper.getLocation()[0] == "") {
            checkPermission()
        } else {
            splashViewModel.addLocation(
                preferenceHelper.getLocation()[0],
                preferenceHelper.getLocation()[1]
            )
        }
        splashViewModel.getLocation().observe(this, Observer {
            Log.e("lokasi","${it[0]} ${it[1]}")
            if (it.isNotEmpty()) {
                splashViewModel.loadNewPage(this)
            }
        })
    }

}
