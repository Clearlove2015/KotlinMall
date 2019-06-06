package com.odbpo.fenggo.user.presenter

import com.odbpo.fenggo.base_library.ext.execute
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.user.data.protocol.UserInfo
import com.odbpo.fenggo.user.presenter.view.UserInfoView
import com.odbpo.fenggo.user.services.UploadServices
import com.odbpo.fenggo.user.services.UserServices
import javax.inject.Inject

class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userServices: UserServices

    @Inject
    lateinit var uploadServices: UploadServices

    fun getUploadToken() {
        if (!checkNetWork())
            return

        mView.showLoading()
        uploadServices.getUploadToken().execute(lifecycleProvider, object : BaseSubscriber<String>(mView) {
            override fun onNext(t: String) {
                mView.onGetUploadTokenResult(t)
            }
        })
    }

    fun editUser(userIcon: String, userName: String, userGender: String, userSign: String) {
        if (!checkNetWork())
            return

        mView.showLoading()
        userServices.editUser(userIcon, userName, userGender, userSign)
            .execute(lifecycleProvider, object : BaseSubscriber<UserInfo>(mView) {
                override fun onNext(t: UserInfo) {
                    mView.onEditUserResult(t)
                }
            })
    }

}