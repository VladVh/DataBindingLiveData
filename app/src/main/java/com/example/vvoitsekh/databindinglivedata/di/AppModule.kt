package com.example.vvoitsekh.databindinglivedata.di

import android.app.Application
import android.content.Context
import com.example.vvoitsekh.databindinglivedata.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by v.voitsekh on 12.01.2018.
 */
@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {

//    @Singleton
//    @Provides
//    fun provideContext(application: Application) = application

}