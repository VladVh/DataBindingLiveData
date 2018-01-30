package com.example.vvoitsekh.databindinglivedata.taskdetail

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.vvoitsekh.databindinglivedata.dbnew.Task
import com.example.vvoitsekh.databindinglivedata.dbnew.TasksDao
import javax.inject.Inject

/**
 * Created by v.voitsekh on 29.01.2018.
 */
class TaskDetailViewModel @Inject constructor(application: Application, tasksDao: TasksDao) : AndroidViewModel(application) {
    var task: Task? = null

    var mTasksDao: TasksDao = tasksDao

    fun start(taskId: String?) {
        taskId?.let {
            task = mTasksDao.getTaskById(taskId)
        }
    }
}