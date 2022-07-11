package com.example.flowscannertest.domain.interactor

import com.example.flowscannertest.domain.mapper.toDeletedResultScanEntity
import com.example.flowscannertest.domain.mapper.toResultScan
import com.example.flowscannertest.domain.mapper.toResultScanEntity
import com.example.flowscannertest.domain.models.ResultScan
import com.example.flowscannertest.domain.repository.ResultScanRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ResultScanInteractorImpl(
    private val repository: ResultScanRepository
) : ResultScanInteractor {
    override fun getResultScan(): Flow<List<ResultScan>> {
        return repository.getSavedResultScan()
            .map { list ->
                list.map { resultScanEntity ->
                    resultScanEntity.toResultScan()
                }
            }
    }

    override suspend fun createResultScan(resultScan: ResultScan) {
        repository.saveResultScan(resultScan.toResultScanEntity())
    }

    override suspend fun deleteResultScan(resultScan: ResultScan) {
        repository.deleteResultScan(resultScan.toDeletedResultScanEntity())
    }
}