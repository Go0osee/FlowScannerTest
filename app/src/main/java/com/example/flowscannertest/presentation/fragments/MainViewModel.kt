package com.example.flowscannertest.presentation.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowscannertest.domain.interactor.ResultScanInteractor
import com.example.flowscannertest.domain.models.ResultScan
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactor: ResultScanInteractor
) : ViewModel() {

    private val _resultScan = MutableLiveData<List<ResultScan>>()
    val resultScan: LiveData<List<ResultScan>> get() = _resultScan

    init {
        initStringsFlow()
    }

    private fun initStringsFlow() {
        interactor.getResultScan()
            .map { _resultScan.postValue(it) }
            .launchIn(viewModelScope)
    }

    fun addScanToData(link: String, date: Date) {
        addScanResult(
            ResultScan(link, date)
        )
    }

    private fun addScanResult(resultScan: ResultScan) {
        viewModelScope.launch {
            interactor.createResultScan(resultScan)
        }
    }

    fun deleteResultScan(resultScan: ResultScan) {
        viewModelScope.launch {
            interactor.deleteResultScan(resultScan)
        }
    }

}