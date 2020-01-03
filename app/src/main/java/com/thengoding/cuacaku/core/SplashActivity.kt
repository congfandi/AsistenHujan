/*
 * Cuacaku
 * TempClass.kt
 * Created by thengoding.com on 3/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.core

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.thengoding.cuacaku.helpers.SharePreferenceHelper
import com.thengoding.cuacaku.locations.LocationHelper
import com.thengoding.cuacaku.viewmodels.SplashViewModel

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
        } else {
            saveLocation()
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
                        saveLocation()
                    }
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                    finish()
                }
                return
            }
        }
    }

    private fun saveLocation() {
        locationHelper.getLatLon {
            preferenceHelper.saveLocation(it)
            splashViewModel.addLocation(it)
        }
    }

    private lateinit var splashViewModel: SplashViewModel
    private lateinit var preferenceHelper: SharePreferenceHelper
    private lateinit var locationHelper: LocationHelper

    private fun initData() {
        locationHelper = LocationHelper(this)
        preferenceHelper = SharePreferenceHelper(this)
        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        checkPermission()
        splashViewModel.getLocation().observe(this, Observer {
            splashViewModel.loadNewPage(this)
        })
    }
}