package com.odbpo.fenggo.base_library.ui.activity

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
}