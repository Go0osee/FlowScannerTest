package com.example.flowscannertest.data.repository

import com.example.flowscannertest.data.storage.ResultScanDao
import com.example.flowscannertest.data.storage.entity.ResultScanEntity
import com.example.flowscannertest.domain.repository.ResultScanRepository
import kotlinx.coroutines.flow.Flow

class ResultScanRepositoryImpl(
    private val resultScanDao: ResultScanDao
) : ResultScanRepository {

    override fun getSavedResultScan(): Flow<List<ResultScanEntity>> =
        resultScanDao.getAllResultScan()

    override suspend fun saveResultScan(resultScanEntity: ResultScanEntity) {
        resultScanDao.saveResultScan(resultScanEntity)
    }

    override suspend fun deleteResultScan(resultScanEntity: ResultScanEntity) {
        resultScanDao.deleteResultScan(resultScanEntity)
    }
}