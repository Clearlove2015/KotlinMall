package com.odbpo.fenggo.user.data.repository

import com.odbpo.fenggo.base_library.data.net.RetrofitFactory
import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import com.odbpo.fenggo.user.data.api.UserApi
import com.odbpo.fenggo.user.data.protocol.LoginReq
import com.odbpo.fenggo.user.data.protocol.RegisterReq
import com.odbpo.fenggo.user.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject

class UserRepository @Inject constructor() {

    fun register(mobile:String,pwd:String,verifyCode:String): Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
            .register(RegisterReq(mobile,pwd,verifyCode))
    }

    fun login(mobile:String,pwd:String,pushId:String): Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
            .login(LoginReq(mobile,pwd,pushId))
    }

}