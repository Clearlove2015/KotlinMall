package com.odbpo.fenggo.user.services.impl

import com.odbpo.fenggo.user.services.UserServices
import rx.Observable

class UserServiceImpl:UserServices {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }
}