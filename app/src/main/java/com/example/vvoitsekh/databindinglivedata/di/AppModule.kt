package com.example.vvoitsekh.databindinglivedata.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by v.voitsekh on 12.01.2018.
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context
}