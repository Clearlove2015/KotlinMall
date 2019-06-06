package com.odbpo.fenggo.user.services

import rx.Observable


interface UploadServices {

    fun getUploadToken():Observable<String>

}