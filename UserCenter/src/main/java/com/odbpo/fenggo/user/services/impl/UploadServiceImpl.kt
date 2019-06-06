package com.odbpo.fenggo.user.services.impl

import com.odbpo.fenggo.base_library.ext.convert
import com.odbpo.fenggo.user.data.repository.UploadRepository
import com.odbpo.fenggo.user.services.UploadServices
import rx.Observable
import javax.inject.Inject

class UploadServiceImpl @Inject constructor():UploadServices {

    @Inject
    lateinit var repository:UploadRepository

    override fun getUploadToken(): Observable<String> {
        return repository.getUploadToken().convert()
    }

}