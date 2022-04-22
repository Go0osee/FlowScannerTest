package com.example.flowscannertest.data.repository

import com.example.flowscannertest.data.storage.ResultScanDao
import com.example.flowscannertest.data.storage.entity.ResultScanEntity
import com.example.flowscannertest.domain.repository.ResultScanRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ResultScanRepositoryImpl(
    private val resultScanDao: ResultScanDao
) : ResultScanRepository {

    override fun getSavedResultScan(): Flow<List<ResultScanEntity>> {
        return flow {
            while (true) {
                emit(resultScanDao.getAllResultScan())
                delay(3000L)
            }
        }.distinctUntilChanged()
            .flowOn(Dispatchers.IO)
    }

    override suspend fun saveResultScan(resultScanEntity: ResultScanEntity) {
        resultScanDao.saveResultScan(resultScanEntity)
    }

    override suspend fun deleteResultScan(resultScanEntity: ResultScanEntity) {
        resultScanDao.deleteResultScan(resultScanEntity)
    }
}