package com.odbpo.fenggo.goodscenter.injection.component

import com.odbpo.fenggo.base_library.injection.PerComponentScope
import com.odbpo.fenggo.base_library.injection.component.ActivityComponent
import com.odbpo.fenggo.goodscenter.injection.module.CartModule
import com.odbpo.fenggo.goodscenter.injection.module.GoodsModule
import com.odbpo.fenggo.goodscenter.ui.activity.GoodsActivity
import com.odbpo.fenggo.goodscenter.ui.fragment.GoodsDetailTabOneFragment
import dagger.Component

/*
    商品Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(GoodsModule::class, CartModule::class))
interface GoodsComponent {
    fun inject(activity: GoodsActivity)
    fun inject(fragment: GoodsDetailTabOneFragment)
}
