package com.odbpo.fenggo.user.data.api

import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import com.odbpo.fenggo.user.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserApi {

    @POST("userCenter/register")
    fun register(@Body req: RegisterReq):Observable<BaseResp<String>>

}