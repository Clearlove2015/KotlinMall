package com.odbpo.fenggo.user.services.impl

import com.odbpo.fenggo.base_library.ext.convertBoolean
import com.odbpo.fenggo.user.data.repository.UserRepository
import com.odbpo.fenggo.user.services.UserServices
import rx.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor():UserServices {

    @Inject
    lateinit var repository:UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        //val repository = UserRepository()//Dagger注入
        return repository.register(mobile,pwd,verifyCode)
            .convertBoolean()
    }
}