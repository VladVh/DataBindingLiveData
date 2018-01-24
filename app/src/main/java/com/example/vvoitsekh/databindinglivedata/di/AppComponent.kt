package com.example.vvoitsekh.databindinglivedata.di

import android.app.Application
import com.example.vvoitsekh.databindinglivedata.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

/**
 * Created by v.voitsekh on 12.01.2018.
 */

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, ActivityBuilder::class, AppModule::class))
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(app: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder
        fun build() : AppComponent
    }
}