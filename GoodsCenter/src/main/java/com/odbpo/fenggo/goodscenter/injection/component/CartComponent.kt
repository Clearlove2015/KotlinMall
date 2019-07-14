package com.odbpo.fenggo.goodscenter.injection.component

import com.odbpo.fenggo.base_library.injection.PerComponentScope
import com.odbpo.fenggo.base_library.injection.component.ActivityComponent
import com.odbpo.fenggo.goodscenter.injection.module.CartModule
import com.odbpo.fenggo.goodscenter.ui.fragment.CartFragment
import dagger.Component

/*
    购物车Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(CartModule::class))
interface CartComponent {
    fun inject(fragment: CartFragment)
}
