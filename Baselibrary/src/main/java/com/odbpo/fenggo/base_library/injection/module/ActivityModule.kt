package com.odbpo.fenggo.base_library.injection.module

import android.app.Activity
import android.content.Context
import com.odbpo.fenggo.base_library.common.BaseApplication
import com.odbpo.fenggo.base_library.injection.ActivityScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(private val activity:Activity) {

    @Provides
    fun providesActivity():Activity{
        return activity
    }

}