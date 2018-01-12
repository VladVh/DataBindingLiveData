package com.example.vvoitsekh.databindinglivedata.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by v.voitsekh on 12.01.2018.
 */

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule, AppModule::class))
interface AppComponent {


}