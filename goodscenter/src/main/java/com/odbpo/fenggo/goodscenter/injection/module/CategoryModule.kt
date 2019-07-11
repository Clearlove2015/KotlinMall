package com.odbpo.fenggo.goodscenter.injection.module

import com.odbpo.fenggo.goodscenter.service.CategoryServices
import com.odbpo.fenggo.goodscenter.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

@Module
class CategoryModule {

    @Provides
    fun providesCategoryServices(services: CategoryServiceImpl):CategoryServices{
        return services
    }

}