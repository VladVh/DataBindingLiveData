package com.example.vvoitsekh.databindinglivedata.di

import com.example.vvoitsekh.databindinglivedata.BooksBorrowedByUserActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

/**
 * Created by v.voitsekh on 12.01.2018.
 */


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(ActivityModule::class))
    abstract fun bindActivity(): BooksBorrowedByUserActivity
}