package com.odbpo.fenggo.goodscenter.presenter.view

import com.odbpo.fenggo.base_library.presenter.view.BaseView
import com.odbpo.fenggo.goodscenter.data.protocol.CartGoods

/*
    购物车页面 视图回调
 */
interface CartListView : BaseView {

    //获取购物车列表
    fun onGetCartListResult(result: MutableList<CartGoods>?)
    //删除购物车
    fun onDeleteCartListResult(result: Boolean)
    //提交购物车
    fun onSubmitCartListResult(result: Int)
}
