package com.odbpo.fenggo.user.presenter

import com.odbpo.fenggo.base_library.ext.execute
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.user.presenter.view.RegisterView
import com.odbpo.fenggo.user.services.UserServices
import com.odbpo.fenggo.user.services.impl.UserServiceImpl
import javax.inject.Inject

class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    lateinit var userServices:UserServices

    fun register(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 业务逻辑
         */
        //val userServices = UserServiceImpl()
        userServices.register(mobile, verifyCode, pwd)
            .execute(object :BaseSubscriber<Boolean>(){
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(t)
                }
            })

    }

}