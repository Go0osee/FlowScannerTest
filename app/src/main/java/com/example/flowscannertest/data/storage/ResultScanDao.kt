package com.example.flowscannertest.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.flowscannertest.data.storage.entity.ResultScanEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultScanDao {
    @Query("SELECT * FROM result_scans")
    fun getAllResultScan(): Flow<List<ResultScanEntity>>

    @Insert
    suspend fun saveResultScan(resultScan: ResultScanEntity)

    @Delete
    suspend fun deleteResultScan(resultScan: ResultScanEntity)
}

