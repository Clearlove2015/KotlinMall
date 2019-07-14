package com.odbpo.fenggo.base_library.common

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.odbpo.fenggo.base_library.injection.component.AppComponent
import com.odbpo.fenggo.base_library.injection.component.DaggerAppComponent
import com.odbpo.fenggo.base_library.injection.module.AppModule

class BaseApplication:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this);
        initInjection()
        context = this

        //ARouter初始化
        ARouter.openLog()    // 打印日志
        ARouter.openDebug()
        ARouter.init(this)
    }

    private fun initInjection() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var context:Context
    }

}