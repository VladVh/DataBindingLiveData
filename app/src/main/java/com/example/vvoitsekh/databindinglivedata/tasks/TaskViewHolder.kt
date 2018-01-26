package com.example.vvoitsekh.databindinglivedata.tasks

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.vvoitsekh.databindinglivedata.databinding.TaskItemBinding
import com.example.vvoitsekh.databindinglivedata.dbnew.Task

/**
 * Created by v.voitsekh on 26.01.2018.
 */
class TaskViewHolder(var binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(task: Task) {
        binding.task = task
        binding.executePendingBindings()
    }
}