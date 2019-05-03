package com.odbpo.fenggo.base_library.common

import android.app.Application
import com.odbpo.fenggo.base_library.injection.component.AppComponent
import com.odbpo.fenggo.base_library.injection.component.DaggerAppComponent
import com.odbpo.fenggo.base_library.injection.module.AppModule

class BaseApplication:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initInjection()
    }

    private fun initInjection() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}