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

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.vvoitsekh.databindinglivedata.R
import com.example.vvoitsekh.databindinglivedata.databinding.DbActivityBinding

import com.example.vvoitsekh.databindinglivedata.dbnew.Task
import com.example.vvoitsekh.databindinglivedata.edit.AddEditTaskActivity
import com.example.vvoitsekh.databindinglivedata.taskdetail.TaskDetailActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class TasksActivity : AppCompatActivity() {

    @Inject
    lateinit var mViewModel: TasksViewModel

    lateinit var mBinding: DbActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView<DbActivityBinding>(this, R.layout.db_activity)
        mBinding.viewModel = mViewModel
        mBinding.setLifecycleOwner(this)
        //setContentView(R.layout.db_activity)
        val adapter = TasksRecyclerAdapter(emptyList(), mViewModel)
        mBinding.recyclerView.adapter = adapter
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mViewModel.openTaskEvent.observe(this, Observer {
            taskId ->  if (taskId != null)
            openTaskDetails(taskId)
        })

        mViewModel.newTaskEvent.observe(this, Observer {

        })
        mViewModel.loadTasks()
    }

    fun addNewTask() {
        val intent = Intent(this, AddEditTaskActivity::class.java)
        startActivityForResult(intent, 1)
    }

    fun openTaskDetails(taskId: String) {
        val intent = Intent(this, TaskDetailActivity::class.java).apply {
            putExtra(TaskDetailActivity.EXTRA_TASK_ID, taskId)
        }
        startActivityForResult(intent, 1)

    }
}
