package com.example.vvoitsekh.databindinglivedata.tasks

import android.support.v7.widget.RecyclerView
import com.example.vvoitsekh.databindinglivedata.databinding.TaskItemBinding
import com.example.vvoitsekh.databindinglivedata.dbnew.Task

/**
 * Created by v.voitsekh on 26.01.2018.
 */
class TaskViewHolder(var binding: TaskItemBinding, var itemListener: TaskItemUserActionsListener) : RecyclerView.ViewHolder(binding.root) {

    fun bind(task: Task) {
        binding.task = task
        binding.listener = itemListener
        binding.executePendingBindings()
    }
}