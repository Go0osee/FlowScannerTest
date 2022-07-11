package com.example.flowscannertest.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flowscannertest.data.storage.entity.ResultScanEntity

@Database(
    entities = [ResultScanEntity::class],
    version = ResultScanDataBase.VERSION
)

abstract class ResultScanDataBase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun getResultScanDao(): ResultScanDao
}