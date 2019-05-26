package com.odbpo.fenggo.user.presenter.view

import com.odbpo.fenggo.base_library.presenter.view.BaseView
import com.odbpo.fenggo.user.data.protocol.UserInfo

interface LoginView:BaseView {

    fun onLoginResult(result:UserInfo)

}