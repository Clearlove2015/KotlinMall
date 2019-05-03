package com.odbpo.fenggo.user.injection.component

import com.odbpo.fenggo.user.RegisterActivity
import com.odbpo.fenggo.user.injection.module.UserModule
import dagger.Component

@Component(modules = arrayOf(UserModule::class))
interface UserComponent {

    fun inject(activity:RegisterActivity)

}