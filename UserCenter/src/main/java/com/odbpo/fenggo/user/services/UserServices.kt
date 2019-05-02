package com.odbpo.fenggo.user.services

import rx.Observable


interface UserServices {

    fun register(mobile:String,pwd:String,verifyCode:String):Observable<Boolean>

}