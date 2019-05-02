package com.odbpo.fenggo.user.services

import rx.Observable


interface UserServices {

    fun register(mobile:String,verifyCode:String,pwd:String):Observable<Boolean>

}