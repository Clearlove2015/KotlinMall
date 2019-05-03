package com.odbpo.fenggo.base_library.injection.component

import android.content.Context
import com.odbpo.fenggo.base_library.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context():Context

}