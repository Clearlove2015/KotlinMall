package com.odbpo.fenggo.base_library.presenter

import com.odbpo.fenggo.base_library.presenter.view.BaseView

open class BasePresenter<T:BaseView> {
    lateinit var mView:T
}