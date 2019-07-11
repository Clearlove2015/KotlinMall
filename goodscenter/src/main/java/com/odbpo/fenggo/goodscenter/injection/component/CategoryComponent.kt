package com.odbpo.fenggo.goodscenter.injection.component

import com.odbpo.fenggo.base_library.injection.component.ActivityComponent
import com.odbpo.fenggo.goodscenter.injection.PerComponentScope
import com.odbpo.fenggo.goodscenter.injection.module.CategoryModule
import com.odbpo.fenggo.goodscenter.ui.fragment.CategoryFragment
import dagger.Component

@PerComponentScope
@Component(
    dependencies = arrayOf(ActivityComponent::class),
    modules = arrayOf(CategoryModule::class)
)
interface CategoryComponent {

    fun inject(categoryFragment: CategoryFragment)

}