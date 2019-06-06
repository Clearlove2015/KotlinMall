package com.odbpo.fenggo.user.presenter.view

import com.odbpo.fenggo.base_library.presenter.view.BaseView
import com.odbpo.fenggo.user.data.protocol.UserInfo

interface UserInfoView:BaseView {

    fun onGetUploadTokenResult(result:String)

    fun onEditUserResult(result:UserInfo)

}