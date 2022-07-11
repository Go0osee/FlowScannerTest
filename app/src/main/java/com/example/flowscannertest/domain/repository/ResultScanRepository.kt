package com.example.flowscannertest.domain.repository

import com.example.flowscannertest.data.storage.entity.ResultScanEntity
import kotlinx.coroutines.flow.Flow

interface ResultScanRepository {
    fun getSavedResultScan(): Flow<List<ResultScanEntity>>

    suspend fun saveResultScan(resultScanEntity: ResultScanEntity)

    suspend fun deleteResultScan(resultScanEntity: ResultScanEntity)
}
