package com.odbpo.fenggo.user.services.impl

import com.odbpo.fenggo.base_library.ext.convert
import com.odbpo.fenggo.base_library.ext.convertBoolean
import com.odbpo.fenggo.user.data.protocol.UserInfo
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

    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
        return repository.login(mobile,pwd,pushId)
            .convert()
    }

    override fun forgetPwd(mobile: String, verfyCode: String): Observable<Boolean> {
        return repository.forgetPwd(mobile,verfyCode)
            .convertBoolean()
    }

    override fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {
        return repository.resetPwd(mobile,pwd)
            .convertBoolean()
    }


}