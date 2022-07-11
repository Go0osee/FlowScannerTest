package com.example.flowscannertest

import android.content.Context
import com.example.flowscannertest.data.di.DataModule
import com.example.flowscannertest.data.di.RoomModule
import com.example.flowscannertest.domain.di.DomainModule
import com.example.flowscannertest.presentation.MainActivity
import com.example.flowscannertest.presentation.di.ViewModelModule
import com.example.flowscannertest.presentation.fragments.HistoryFragment
import com.example.flowscannertest.presentation.fragments.ScannerFragment
import com.tms.dagger2testan12.utills.di.UtilsModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        ViewModelModule::class,
        RoomModule::class,
        DomainModule::class,
        DataModule::class,
        UtilsModule::class
    ]
)
interface AppComponent {
    fun inject(target: MainActivity)
    fun inject(target: HistoryFragment)
    fun inject(target: ScannerFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun buildContext(context: Context): Builder

        fun build(): AppComponent
    }
}