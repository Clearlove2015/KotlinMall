package com.odbpo.fenggo.user.presenter

import com.odbpo.fenggo.base_library.ext.execute
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.user.presenter.view.ForgetPwdView
import com.odbpo.fenggo.user.services.UserServices
import javax.inject.Inject

class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {

    @Inject
    lateinit var userServices: UserServices

    fun forgetPwd(mobile: String, verifyCode: String) {
        /**
         * 业务逻辑
         */
        //val userServices = UserServiceImpl()

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userServices.forgetPwd(mobile, verifyCode)
            .execute(lifecycleProvider, object : BaseSubscriber<Boolean>(mView) {
                override fun onNext(t: Boolean) {
                    if(t)
                    mView.onForgetPwdResult("验证成功")
                }
            })

    }

}