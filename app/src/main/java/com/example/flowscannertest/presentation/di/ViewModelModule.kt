package com.example.flowscannertest.presentation.di

import com.example.flowscannertest.domain.interactor.ResultScanInteractor
import com.example.flowscannertest.presentation.fragments.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun provideFragmentViewModel(
        interactor: ResultScanInteractor
    ): MainViewModel {
        return MainViewModel(interactor)
    }
}