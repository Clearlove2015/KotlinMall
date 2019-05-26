package com.odbpo.fenggo.user.injection.component

import com.odbpo.fenggo.base_library.injection.component.ActivityComponent
import com.odbpo.fenggo.user.injection.PerComponentScope
import com.odbpo.fenggo.user.injection.module.UserModule
import com.odbpo.fenggo.user.ui.activity.LoginActivity
import com.odbpo.fenggo.user.ui.activity.RegisterActivity
import dagger.Component

@PerComponentScope
@Component(
    dependencies = arrayOf(ActivityComponent::class),
    modules = arrayOf(UserModule::class)
)
interface UserComponent {

    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)

}