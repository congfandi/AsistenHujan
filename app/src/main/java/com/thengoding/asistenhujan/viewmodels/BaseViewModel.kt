package com.thengoding.asistenhujan.viewmodels

import androidx.lifecycle.ViewModel
import com.thengoding.asistenhujan.api.RestApi
import com.thengoding.asistenhujan.helpers.NetworkModule
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var restApi: RestApi

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is CurrentViewModel -> injector.inject(this)
        }
    }
}