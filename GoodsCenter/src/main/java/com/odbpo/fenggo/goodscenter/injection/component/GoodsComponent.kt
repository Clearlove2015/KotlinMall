package com.odbpo.fenggo.goodscenter.injection.component

import com.odbpo.fenggo.base_library.injection.component.ActivityComponent
import com.odbpo.fenggo.goodscenter.injection.PerComponentScope
import com.odbpo.fenggo.goodscenter.injection.module.GoodsModule
import com.odbpo.fenggo.goodscenter.ui.activity.GoodsActivity
import dagger.Component

@PerComponentScope
@Component(
    dependencies = arrayOf(ActivityComponent::class),
    modules = arrayOf(GoodsModule::class)
)
interface GoodsComponent {

    fun inject(goodsActivity: GoodsActivity)

}