package com.odbpo.fenggo.base_library.ui.activity

import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.presenter.view.BaseView

open class BaseMVPActivity<T:BasePresenter<*>>: BaseActivity(),BaseView {
    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var mPresenter:T
}