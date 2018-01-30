package com.example.vvoitsekh.databindinglivedata.taskdetail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.vvoitsekh.databindinglivedata.R
import com.example.vvoitsekh.databindinglivedata.databinding.TaskDetailBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by v.voitsekh on 29.01.2018.
 */
class TaskDetailActivity: AppCompatActivity() {
    lateinit var mBinding : TaskDetailBinding

    @Inject
    lateinit var mViewModel: TaskDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView<TaskDetailBinding>(this, R.layout.task_detail)
        mBinding.viewmodel = mViewModel
        mBinding.setLifecycleOwner(this)

        val id = intent.extras.getString(EXTRA_TASK_ID)
        if (id != null) {
            mViewModel.start(id)
        }
    }

    companion object {

        const val EXTRA_TASK_ID = "TASK_ID"

    }
}