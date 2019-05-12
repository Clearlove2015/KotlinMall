package com.odbpo.fenggo.user.injection.component

import com.odbpo.fenggo.base_library.injection.component.ActivityComponent
import com.odbpo.fenggo.user.RegisterActivity
import com.odbpo.fenggo.user.injection.PerComponentScope
import com.odbpo.fenggo.user.injection.module.UserModule
import dagger.Component

@PerComponentScope
@Component(
    dependencies = arrayOf(ActivityComponent::class),
    modules = arrayOf(UserModule::class)
)
interface UserComponent {

    fun inject(activity: RegisterActivity)

}