package com.odbpo.fenggo.goodscenter.presenter

import com.odbpo.fenggo.base_library.ext.execute
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.goodscenter.data.protocol.CartGoods
import com.odbpo.fenggo.goodscenter.presenter.view.CartListView
import com.odbpo.fenggo.goodscenter.service.CartService
import javax.inject.Inject

/*
    购物车 Presenter
 */
class CartListPresenter @Inject constructor() : BasePresenter<CartListView>() {

    @Inject
    lateinit var cartService: CartService


    /*
        获取购物车列表
     */
    fun getCartList() {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.getCartList().execute(lifecycleProvider, object : BaseSubscriber<MutableList<CartGoods>?>(mView) {
            override fun onNext(t: MutableList<CartGoods>?) {
                mView.onGetCartListResult(t)
            }
        })

    }

    /*
        删除购物车商品
     */
    fun deleteCartList(list: List<Int>) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.deleteCartList(list).execute(lifecycleProvider, object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onDeleteCartListResult(t)
            }
        })

    }

    /*
        提交购物车商品
     */
    fun submitCart(list: MutableList<CartGoods>, totalPrice: Long) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.submitCart(list, totalPrice).execute(lifecycleProvider, object : BaseSubscriber<Int>(mView) {
            override fun onNext(t: Int) {
                mView.onSubmitCartListResult(t)
            }
        })

    }

}
