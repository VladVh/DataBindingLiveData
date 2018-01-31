package com.example.vvoitsekh.databindinglivedata.edit

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.vvoitsekh.databindinglivedata.dbnew.Task
import com.example.vvoitsekh.databindinglivedata.dbnew.TasksDao
import com.example.vvoitsekh.databindinglivedata.utils.SingleLiveEvent
import javax.inject.Inject

/**
 * Created by v.voitsekh on 30.01.2018.
 */
class AddEditTaskViewModel @Inject constructor(application: Application, private val tasksDao: TasksDao) : AndroidViewModel(application) {
    var taskId: String? = null
    private val isNewTask get() = taskId == null
    private var isTaskCompleted = false

    var title = MutableLiveData<String>()
    var description = MutableLiveData<String>()

    val taskUpdatedEvent = SingleLiveEvent<Void>()
    var task: Task? = null

    fun start(taskId: String?) {
        this.taskId = taskId
        taskId?.let {
            task = tasksDao.getTaskById(taskId)
            task?.let {
                title.value = it.title
                description.value = it.description
                isTaskCompleted = it.isCompleted
            }

        }
    }

    fun saveTask() {
        if (isNewTask) {
            createTask()
        } else {
            taskId?.let {
                val task = Task(it, title.value.orEmpty(), description.value.orEmpty())
                task.isCompleted = isTaskCompleted
                tasksDao.updateTask(task)
            }
        }
        taskUpdatedEvent.call()
    }

    private fun createTask() {
        val task = Task(title.value.orEmpty(), description.value.orEmpty())
        tasksDao.insertTask(task)
        taskUpdatedEvent.call()
    }
}