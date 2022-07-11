package com.example.flowscannertest.data.di

import com.example.flowscannertest.data.repository.ResultScanRepositoryImpl
import com.example.flowscannertest.data.storage.ResultScanDao
import com.example.flowscannertest.domain.repository.ResultScanRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideResultScanRepository(
        resultScanDao: ResultScanDao
    ): ResultScanRepository {
        return ResultScanRepositoryImpl(resultScanDao)
    }
}

