package com.example.vvoitsekh.databindinglivedata.dbnew

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.vvoitsekh.databindinglivedata.db.Book
import com.example.vvoitsekh.databindinglivedata.db.Loan
import com.example.vvoitsekh.databindinglivedata.db.User

/**
 * Created by v.voitsekh on 25.01.2018.
 */
@Database(entities = arrayOf(Task::class), version = 1)
abstract class TasksDatabase: RoomDatabase() {

    abstract fun taskDao(): TasksDao

    companion object {
        fun buildDatabase(context: Context): TasksDatabase =
                Room.databaseBuilder(context, TasksDatabase::class.java, "tasksDb").allowMainThreadQueries().build()
    }
}