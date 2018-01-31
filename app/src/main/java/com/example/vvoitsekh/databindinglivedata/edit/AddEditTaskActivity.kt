package com.example.vvoitsekh.databindinglivedata.edit

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.vvoitsekh.databindinglivedata.R
import com.example.vvoitsekh.databindinglivedata.databinding.AddEditTaskBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by v.voitsekh on 30.01.2018.
 */
class AddEditTaskActivity: AppCompatActivity() {
    lateinit var mBinding : AddEditTaskBinding

    @Inject
    lateinit var mViewModel: AddEditTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView<AddEditTaskBinding>(this, R.layout.add_edit_task)
        mBinding.viewmodel = mViewModel

        val id = intent.extras.getString(ARGUMENT_EDIT_TASK_ID)
        if (id != null) {
            mViewModel.start(id)
        }

        mViewModel.taskUpdatedEvent.observe(this, Observer { this.onTaskSaved() })
    }

    private fun onTaskSaved() {
        setResult(1)
        finish()
    }

    companion object {
        const val ARGUMENT_EDIT_TASK_ID = "EDIT_TASK_ID"
    }
}