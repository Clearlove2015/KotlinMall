package com.odbpo.fenggo.user.presenter

import com.odbpo.fenggo.base_library.ext.execute
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.user.presenter.view.RegisterView
import com.odbpo.fenggo.user.services.UserServices
import javax.inject.Inject

class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userServices: UserServices

    fun register(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 业务逻辑
         */
        //val userServices = UserServiceImpl()

        if(!checkNetWork()){
           return
        }
        mView.showLoading()
        userServices.register(mobile, verifyCode, pwd)
            .execute(lifecycleProvider, object : BaseSubscriber<Boolean>(mView) {
                override fun onNext(t: Boolean) {
                    if(t)
                    mView.onRegisterResult("注册成功")
                }
            })

    }

}