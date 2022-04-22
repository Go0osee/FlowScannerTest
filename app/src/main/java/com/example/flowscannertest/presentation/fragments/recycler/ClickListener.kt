package com.example.flowscannertest.presentation.fragments.recycler

import com.example.flowscannertest.domain.models.ResultScan

interface ClickListener {
    fun onDeleteClickListener(resultScan: ResultScan)
    fun onShareClickListener(resultScan: ResultScan)
}