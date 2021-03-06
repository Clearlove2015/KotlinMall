package com.odbpo.fenggo.base_library.injection.module

import android.content.Context
import com.odbpo.fenggo.base_library.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context:BaseApplication) {

    @Provides
    @Singleton
    fun providesContext():Context{
        return context
    }

}