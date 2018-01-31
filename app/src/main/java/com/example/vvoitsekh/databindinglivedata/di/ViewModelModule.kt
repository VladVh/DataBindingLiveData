package com.example.vvoitsekh.databindinglivedata.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.vvoitsekh.databindinglivedata.tasks.TasksViewModel
import com.example.vvoitsekh.databindinglivedata.ViewModelFactory
import com.example.vvoitsekh.databindinglivedata.edit.AddEditTaskViewModel
import com.example.vvoitsekh.databindinglivedata.taskdetail.TaskDetailViewModel
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
    @ViewModelKey(TasksViewModel::class)
    abstract fun bindTaskViewModel(viewModel: TasksViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TaskDetailViewModel::class)
    abstract fun bindTaskDetailViewModel(viewModel: TaskDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddEditTaskViewModel::class)
    abstract fun bindAddEditTaskViewModel(viewModel: AddEditTaskViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.NewInstanceFactory
}