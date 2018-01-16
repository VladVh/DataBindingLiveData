package com.example.vvoitsekh.databindinglivedata.di

import com.example.vvoitsekh.databindinglivedata.BooksBorrowedByUserActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by v.voitsekh on 12.01.2018.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindActivity(): BooksBorrowedByUserActivity
}