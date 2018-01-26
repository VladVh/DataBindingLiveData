package com.example.vvoitsekh.databindinglivedata.dbnew

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by v.voitsekh on 25.01.2018.
 */
@Entity(tableName = "tasks")
data class Task(
        @PrimaryKey @ColumnInfo(name = "entryId") var id: String = UUID.randomUUID().toString(),
        @ColumnInfo(name = "title") var title: String = "",
        @ColumnInfo(name = "description") var description: String = "",
        @ColumnInfo(name = "completed") var isCompleted: Boolean = false) {
}