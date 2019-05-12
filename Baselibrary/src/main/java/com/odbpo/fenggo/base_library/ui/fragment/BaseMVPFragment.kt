package com.odbpo.fenggo.base_library.ui.fragment

import android.os.Bundle
import com.odbpo.fenggo.base_library.common.BaseApplication
import com.odbpo.fenggo.base_library.injection.component.ActivityComponent
import com.odbpo.fenggo.base_library.injection.component.DaggerActivityComponent
import com.odbpo.fenggo.base_library.injection.module.ActivityModule
import com.odbpo.fenggo.base_library.injection.module.LifeCycleProviderModule
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.presenter.view.BaseView
import javax.inject.Inject

open abstract class BaseMVPFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {
    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((activity!!.application as BaseApplication).appComponent)
            .activityModule(ActivityModule(activity!!))
            .lifeCycleProviderModule(LifeCycleProviderModule(this))
            .build()
    }

}