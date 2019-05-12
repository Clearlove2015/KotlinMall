package com.odbpo.fenggo.base_library.injection.component

import android.app.Activity
import android.content.Context
import com.odbpo.fenggo.base_library.injection.ActivityScope
import com.odbpo.fenggo.base_library.injection.module.ActivityModule
import com.odbpo.fenggo.base_library.injection.module.LifeCycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

@ActivityScope
@Component(
    dependencies = arrayOf(AppComponent::class),
    modules = arrayOf(ActivityModule::class, LifeCycleProviderModule::class)
)
interface ActivityComponent {

    fun activity(): Activity

    fun context(): Context

    fun lifeCycleProvider(): LifecycleProvider<*>

}