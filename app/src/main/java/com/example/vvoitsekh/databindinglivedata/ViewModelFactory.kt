package com.example.vvoitsekh.databindinglivedata

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import java.lang.IllegalArgumentException
import javax.inject.Inject

/**
 * Created by v.voitsekh on 12.01.2018.
 */

class ViewModelFactory @Inject constructor(private val app: Application): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(BooksBorrowedByUserViewModel::class.java) -> BooksBorrowedByUserViewModel(app)
                    else ->
                            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T
}