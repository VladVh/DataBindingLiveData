/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.vvoitsekh.databindinglivedata.tasks

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.vvoitsekh.databindinglivedata.dbnew.Task
import com.example.vvoitsekh.databindinglivedata.dbnew.TasksDao


import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TasksViewModel @Inject constructor(application: Application, tasksDao: TasksDao) : AndroidViewModel(application) {

    val tasks: LiveData<List<Task>>

    var mTasksDao: TasksDao = tasksDao

    init {

        //createDb()
        //DatabaseInitializer.populateAsync(mDb)
        // Books is a LiveData object so updates are observed.
        tasks = mTasksDao.getTasks()
    }
    fun getAllTasks() = tasks

    fun addBook() {
        var task = Task()
        task.title = "test";
        mTasksDao.insertTask(task)
    }
}
