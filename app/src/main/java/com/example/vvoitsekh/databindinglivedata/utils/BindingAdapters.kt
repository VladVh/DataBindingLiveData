package com.example.vvoitsekh.databindinglivedata.utils

import android.view.View.GONE
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.vvoitsekh.databindinglivedata.dbnew.Task
import com.example.vvoitsekh.databindinglivedata.tasks.TasksRecyclerAdapter


/**
 * Created by v.voitsekh on 30.01.2018.
 */
object BindingAdapters {
    @BindingAdapter("app:visibleGone")
    @JvmStatic fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @BindingAdapter("app:items")
    @JvmStatic fun setItems(recyclerView: RecyclerView, items: List<Task>?) {
        with(recyclerView.adapter as TasksRecyclerAdapter) {
            if (items != null)
                replaceData(items)
        }
    }
}