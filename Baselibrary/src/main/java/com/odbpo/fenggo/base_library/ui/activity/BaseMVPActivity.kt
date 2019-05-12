package com.odbpo.fenggo.base_library.ui.activity

import android.os.Bundle
import com.odbpo.fenggo.base_library.common.BaseApplication
import com.odbpo.fenggo.base_library.injection.component.ActivityComponent
import com.odbpo.fenggo.base_library.injection.component.DaggerActivityComponent
import com.odbpo.fenggo.base_library.injection.module.ActivityModule
import com.odbpo.fenggo.base_library.injection.module.LifeCycleProviderModule
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.presenter.view.BaseView
import javax.inject.Inject

open class BaseMVPActivity<T:BasePresenter<*>>: BaseActivity(),BaseView {
    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    @Inject
    lateinit var mPresenter:T

    lateinit var activityComponent:ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
    }

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifeCycleProviderModule(LifeCycleProviderModule(this))
            .build()
    }

}