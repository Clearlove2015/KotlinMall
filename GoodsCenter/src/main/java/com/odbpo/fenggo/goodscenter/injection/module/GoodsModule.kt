package com.odbpo.fenggo.goodscenter.injection.module

import com.odbpo.fenggo.goodscenter.service.GoodsServices
import com.odbpo.fenggo.goodscenter.service.impl.GoodsServiceImpl
import dagger.Module
import dagger.Provides

@Module
class GoodsModule {

    @Provides
    fun providesGoodsServices(services: GoodsServiceImpl):GoodsServices{
        return services
    }

}