package com.odbpo.fenggo.user.services

import com.odbpo.fenggo.user.data.protocol.UserInfo
import rx.Observable


interface UserServices {

    fun register(mobile:String,pwd:String,verifyCode:String):Observable<Boolean>

    fun login(mobile:String,pwd:String,pushId:String):Observable<UserInfo>

}