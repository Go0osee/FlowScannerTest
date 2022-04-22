package com.example.flowscannertest.domain.mapper

import com.example.flowscannertest.data.storage.entity.ResultScanEntity
import com.example.flowscannertest.domain.models.ResultScan
import java.text.SimpleDateFormat
import java.util.*

fun ResultScanEntity.toResultScan() =
    ResultScan(
        link = link,
        dateAndTime = (time + date).toDate(),
        id = id
    )

fun ResultScan.toResultScanEntity() =
    ResultScanEntity(
        link = link,
        time = dateAndTime.toTimeString(),
        date = dateAndTime.toDateString()
    )

fun ResultScan.toDeletedResultScanEntity() =
    ResultScanEntity(
        link = link,
        time = dateAndTime.toTimeString(),
        date = dateAndTime.toDateString(),
        id = id
    )

fun Date.toTimeString(): String =
    SimpleDateFormat("HH:mm:ss").format(this)

fun Date.toDateString(): String =
    SimpleDateFormat("dd.MM.yyyy").format(this)

fun String.toDate(): Date =
    SimpleDateFormat("HH:mm:ss" + "dd.MM.yyyy").parse(this)