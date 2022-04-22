package com.example.flowscannertest.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.flowscannertest.data.storage.entity.ResultScanEntity

@Dao
interface ResultScanDao {
    @Query("SELECT * FROM result_scans")
    suspend fun getAllResultScan(): List<ResultScanEntity>

    @Insert
    suspend fun saveResultScan(resultScan: ResultScanEntity)

    @Delete
    suspend fun deleteResultScan(resultScan: ResultScanEntity)
}

