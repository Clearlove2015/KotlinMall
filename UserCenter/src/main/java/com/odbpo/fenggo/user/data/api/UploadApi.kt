package com.odbpo.fenggo.user.data.api

import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import retrofit2.http.POST
import rx.Observable

interface UploadApi {

    @POST("common/getUploadToken")
    fun getUploadToken():Observable<BaseResp<String>>

}