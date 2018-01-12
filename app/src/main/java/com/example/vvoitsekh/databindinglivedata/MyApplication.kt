package com.example.vvoitsekh.databindinglivedata

import com.example.vvoitsekh.databindinglivedata.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by v.voitsekh on 12.01.2018.
 */
class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent  = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}