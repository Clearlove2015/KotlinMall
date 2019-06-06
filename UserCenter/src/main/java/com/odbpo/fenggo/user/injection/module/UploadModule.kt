package com.odbpo.fenggo.user.injection.module

import com.odbpo.fenggo.user.services.UploadServices
import com.odbpo.fenggo.user.services.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UploadModule {

    @Provides
    fun providesUploadService(services: UploadServiceImpl):UploadServices{
        return services
    }

}