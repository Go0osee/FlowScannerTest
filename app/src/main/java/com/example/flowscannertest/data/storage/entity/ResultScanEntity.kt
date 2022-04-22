package com.example.flowscannertest.data.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_scans")
data class ResultScanEntity(
    @ColumnInfo(name = "link")
    val link: String,
    @ColumnInfo(name = "time")
    val time: String,
    @ColumnInfo(name = "date")
    val date: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)