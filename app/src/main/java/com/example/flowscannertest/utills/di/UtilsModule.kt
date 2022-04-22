package com.tms.dagger2testan12.utills.di

import android.content.Context
import com.tms.dagger2testan12.utills.ResourceProvider
import com.tms.dagger2testan12.utills.ResourceProviderImpl
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProviderImpl(context)
    }
}