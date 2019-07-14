package com.kotlin.goods.data.protocol

import com.odbpo.fenggo.goodscenter.data.protocol.CartGoods

/*
    提交购物车
 */
data class SubmitCartReq(val goodsList: List<CartGoods>, val totalPrice: Long)
