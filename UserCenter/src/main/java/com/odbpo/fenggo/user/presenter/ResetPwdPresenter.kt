package com.odbpo.fenggo.user.presenter

import com.odbpo.fenggo.base_library.ext.execute
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.user.presenter.view.ResetPwdView
import com.odbpo.fenggo.user.services.UserServices
import javax.inject.Inject

class ResetPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>() {

    @Inject
    lateinit var userServices: UserServices

    fun resetPwd(mobile: String, pwd: String) {
        /**
         * 业务逻辑
         */
        //val userServices = UserServiceImpl()

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userServices.resetPwd(mobile, pwd)
            .execute(lifecycleProvider, object : BaseSubscriber<Boolean>(mView) {
                override fun onNext(t: Boolean) {
                    if(t)
                    mView.onResetPwdResult("验证成功")
                }
            })

    }

}