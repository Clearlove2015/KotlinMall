package com.odbpo.fenggo.user.services.impl

import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import com.odbpo.fenggo.base_library.rx.BaseException
import com.odbpo.fenggo.user.data.repository.UserRepository
import com.odbpo.fenggo.user.services.UserServices
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

class UserServiceImpl2 @Inject constructor():UserServices {

    @Inject
    lateinit var repository:UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        //val repository = UserRepository()//Dagger注入
        return repository.register(mobile,pwd,verifyCode)
            .flatMap(object :Func1<BaseResp<String>,Observable<Boolean>>{
                override fun call(t: BaseResp<String>): Observable<Boolean> {
                    if(t.status!=0){
                        return Observable.error(BaseException(t.status,t.message))
                    }
                    return Observable.just(false)
                }
            })
    }
}