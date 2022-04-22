package com.example.flowscannertest.domain.di

import com.example.flowscannertest.domain.interactor.ResultScanInteractor
import com.example.flowscannertest.domain.interactor.ResultScanInteractorImpl
import com.example.flowscannertest.domain.repository.ResultScanRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideResultScanInteractor(
        repository: ResultScanRepository
    ): ResultScanInteractor {
        return ResultScanInteractorImpl(repository)
    }
}


