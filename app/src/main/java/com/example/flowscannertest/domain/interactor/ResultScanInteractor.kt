package com.example.flowscannertest.domain.interactor

import com.example.flowscannertest.domain.models.ResultScan
import kotlinx.coroutines.flow.Flow

interface ResultScanInteractor {
    fun getResultScan(): Flow<List<ResultScan>>

    suspend fun createResultScan(resultScan: ResultScan)

    suspend fun deleteResultScan(resultScan: ResultScan)
}