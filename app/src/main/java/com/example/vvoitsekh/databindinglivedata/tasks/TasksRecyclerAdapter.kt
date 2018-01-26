package com.example.vvoitsekh.databindinglivedata.tasks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.vvoitsekh.databindinglivedata.databinding.TaskItemBinding
import com.example.vvoitsekh.databindinglivedata.dbnew.Task

/**
 * Created by v.voitsekh on 26.01.2018.
 */
class TasksRecyclerAdapter(
        private var tasks: List<Task>,
        private val tasksViewModel: TasksViewModel
): RecyclerView.Adapter<TaskViewHolder>() {

    override fun onBindViewHolder(holder: TaskViewHolder?, position: Int) {
        val task = tasks[position]
        holder?.bind(task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: TaskItemBinding? = TaskItemBinding.inflate(layoutInflater, parent, false)
        return TaskViewHolder(itemBinding!!)
    }

    override fun getItemCount(): Int {
        return tasks.count()
    }

    fun replaceData(tasks: List<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }
}