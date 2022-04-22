package com.example.flowscannertest.domain.interactor

import com.example.flowscannertest.domain.models.ResultScan
import kotlinx.coroutines.flow.Flow

interface ResultScanInteractor {
    suspend fun createResultScan(resultScan: ResultScan)

    fun getResultScan(): Flow<List<ResultScan>>

    suspend fun deleteResultScan(resultScan: ResultScan)
}