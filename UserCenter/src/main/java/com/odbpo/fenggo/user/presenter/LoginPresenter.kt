package com.odbpo.fenggo.user.presenter

import com.odbpo.fenggo.base_library.ext.execute
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.user.data.protocol.UserInfo
import com.odbpo.fenggo.user.presenter.view.LoginView
import com.odbpo.fenggo.user.services.UserServices
import javax.inject.Inject

class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userServices: UserServices

    fun login(mobile: String, pwd: String, pushId: String) {
        /**
         * 业务逻辑
         */
        //val userServices = UserServiceImpl()

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userServices.login(mobile, pwd, pushId)
            .execute(lifecycleProvider, object : BaseSubscriber<UserInfo>(mView) {
                override fun onNext(t: UserInfo) {
                    mView.onLoginResult(t)
                }
            })

    }

}