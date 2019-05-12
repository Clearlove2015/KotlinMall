package com.odbpo.fenggo.base_library.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

@Module
class LifeCycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @Provides
    fun providesLifeCycleProvider():LifecycleProvider<*>{
        return lifecycleProvider
    }

}