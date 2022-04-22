package com.example.flowscannertest.data.di

import android.content.Context
import androidx.room.Room
import com.example.flowscannertest.data.storage.ResultScanDao
import com.example.flowscannertest.data.storage.ResultScanDataBase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provideResultScanDataBase(
        context: Context
    ): ResultScanDataBase {
        return Room.databaseBuilder(
            context,
            ResultScanDataBase::class.java,
            "result_scan"
        ).build()
    }

    @Provides
    fun provideResultScanDao(
        resultScanDataBase: ResultScanDataBase
    ): ResultScanDao {
        return resultScanDataBase.getResultScanDao()
    }
}
