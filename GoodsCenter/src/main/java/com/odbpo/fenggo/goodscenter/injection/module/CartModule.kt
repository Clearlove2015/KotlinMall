package com.odbpo.fenggo.goodscenter.injection.module

import com.odbpo.fenggo.goodscenter.service.CartService
import com.odbpo.fenggo.goodscenter.service.impl.CartServiceImpl
import dagger.Module
import dagger.Provides

/*
    购物车Module
 */
@Module
class CartModule {

    @Provides
    fun provideCartservice(cartService: CartServiceImpl): CartService {
        return cartService
    }

}
