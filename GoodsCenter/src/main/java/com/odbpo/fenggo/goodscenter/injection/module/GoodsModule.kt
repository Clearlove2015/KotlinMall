package com.odbpo.fenggo.goodscenter.injection.module

import com.odbpo.fenggo.goodscenter.service.GoodsServices
import com.odbpo.fenggo.goodscenter.service.impl.GoodsServiceImpl
import dagger.Module
import dagger.Provides

/*
    商品Module
 */
@Module
class GoodsModule {

    @Provides
    fun provideGoodservice(goodsService: GoodsServiceImpl): GoodsServices {
        return goodsService
    }

}
