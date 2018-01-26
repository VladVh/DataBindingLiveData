package com.example.vvoitsekh.databindinglivedata.di

import com.example.vvoitsekh.databindinglivedata.tasks.TasksActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by v.voitsekh on 12.01.2018.
 */


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(ActivityModule::class))
    abstract fun bindActivity(): TasksActivity
}