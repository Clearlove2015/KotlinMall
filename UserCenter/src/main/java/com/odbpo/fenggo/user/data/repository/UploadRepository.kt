package com.odbpo.fenggo.user.data.repository

import com.odbpo.fenggo.base_library.data.net.RetrofitFactory
import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import com.odbpo.fenggo.user.data.api.UploadApi
import rx.Observable
import javax.inject.Inject

class UploadRepository @Inject constructor() {

    fun getUploadToken(): Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UploadApi::class.java)
            .getUploadToken()
    }

}