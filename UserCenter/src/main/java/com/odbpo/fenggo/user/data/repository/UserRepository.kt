package com.odbpo.fenggo.user.data.repository

import com.odbpo.fenggo.base_library.data.net.RetrofitFactory
import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import com.odbpo.fenggo.user.data.api.UserApi
import com.odbpo.fenggo.user.data.protocol.RegisterReq
import rx.Observable

class UserRepository {

    fun register(mobile:String,pwd:String,verifyCode:String): Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
            .register(RegisterReq(mobile,pwd,verifyCode))
    }

}