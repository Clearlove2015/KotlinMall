package com.odbpo.fenggo.base_library.injection.component

import android.app.Activity
import android.content.Context
import com.odbpo.fenggo.base_library.injection.ActivityScope
import com.odbpo.fenggo.base_library.injection.module.ActivityModule
import com.odbpo.fenggo.base_library.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun activity():Activity

}