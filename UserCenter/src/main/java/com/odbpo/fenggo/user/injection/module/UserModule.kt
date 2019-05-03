package com.odbpo.fenggo.user.injection.module

import com.odbpo.fenggo.user.services.UserServices
import com.odbpo.fenggo.user.services.impl.UserServiceImpl
import com.odbpo.fenggo.user.services.impl.UserServiceImpl2
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UserModule {

    @Provides
    @Named("service")
    fun providesUserServices(services: UserServiceImpl):UserServices{
        return services
    }

    @Provides
    @Named("service2")
    fun providesUserServices2(services: UserServiceImpl2):UserServices{
        return services
    }

}