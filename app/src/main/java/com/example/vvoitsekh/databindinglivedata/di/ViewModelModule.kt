package com.example.vvoitsekh.databindinglivedata.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.vvoitsekh.databindinglivedata.BooksBorrowedByUserViewModel
import com.example.vvoitsekh.databindinglivedata.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by v.voitsekh on 16.01.2018.
 */
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BooksBorrowedByUserViewModel::class)
    abstract fun bindViewModel(viewModel: BooksBorrowedByUserViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.NewInstanceFactory
}