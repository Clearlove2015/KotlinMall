package com.odbpo.fenggo.user.presenter

import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.user.presenter.view.RegisterView

class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(mobile:String,verifyCode:String){
        /**
         * 业务逻辑
         */
        mView.onRegisterResult(true)
    }

}