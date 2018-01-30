package com.example.vvoitsekh.databindinglivedata.tasks

import android.view.View
import com.example.vvoitsekh.databindinglivedata.dbnew.Task

/**
 * Created by v.voitsekh on 29.01.2018.
 */
interface TaskItemUserActionsListener {
    fun onCompleteChanged(task: Task, view: View)

    fun onTaskClicked(task: Task)
}