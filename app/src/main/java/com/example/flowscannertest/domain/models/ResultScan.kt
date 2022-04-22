package com.example.flowscannertest.domain.models

import java.util.*

data class ResultScan(
    val link: String,
    val dateAndTime: Date,
    val id: Int = 0
)