package com.odbpo.fenggo.base_library.ui.activity

import android.os.Bundle
import com.odbpo.fenggo.base_library.common.BaseApplication
import com.odbpo.fenggo.base_library.injection.component.ActivityComponent
import com.odbpo.fenggo.base_library.injection.component.DaggerActivityComponent
import com.odbpo.fenggo.base_library.injection.module.ActivityModule
import com.odbpo.fenggo.base_library.injection.module.LifeCycleProviderModule
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.presenter.view.BaseView
import com.odbpo.fenggo.base_library.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

open abstract class BaseMVPActivity<T:BasePresenter<*>>: BaseActivity(),BaseView {

    @Inject
    lateinit var mPresenter:T

    lateinit var activityComponent:ActivityComponent

    lateinit var mLoadingDialog:ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
        mLoadingDialog = ProgressLoading.create(this)
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifeCycleProviderModule(LifeCycleProviderModule(this))
            .build()
    }

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(text:String) {
        toast(text)
    }

}