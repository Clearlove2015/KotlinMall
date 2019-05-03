package com.odbpo.fenggo.user.injection.module

import com.odbpo.fenggo.user.services.UserServices
import com.odbpo.fenggo.user.services.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun providesUserServices(services: UserServiceImpl):UserServices{
        return services
    }

}