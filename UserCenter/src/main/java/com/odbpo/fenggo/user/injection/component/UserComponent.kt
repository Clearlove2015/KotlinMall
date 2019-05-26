package com.odbpo.fenggo.user.injection.component

import com.odbpo.fenggo.base_library.injection.component.ActivityComponent
import com.odbpo.fenggo.user.injection.PerComponentScope
import com.odbpo.fenggo.user.injection.module.UserModule
import com.odbpo.fenggo.user.ui.activity.*
import dagger.Component

@PerComponentScope
@Component(
    dependencies = arrayOf(ActivityComponent::class),
    modules = arrayOf(UserModule::class)
)
interface UserComponent {

    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
    fun inject(activity: UserInfoActivity)

}