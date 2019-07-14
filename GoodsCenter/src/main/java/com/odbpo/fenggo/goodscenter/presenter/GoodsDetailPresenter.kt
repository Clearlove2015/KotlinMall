package com.odbpo.fenggo.goodscenter.presenter

import com.kotlin.base.utils.AppPrefsUtils
import com.odbpo.fenggo.base_library.ext.execute
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.goodscenter.common.GoodsConstant
import com.odbpo.fenggo.goodscenter.data.protocol.Goods
import com.odbpo.fenggo.goodscenter.presenter.view.GoodsDetailView
import com.odbpo.fenggo.goodscenter.service.CartService
import com.odbpo.fenggo.goodscenter.service.GoodsServices
import javax.inject.Inject

/*
    商品详情 Presenter
 */
class GoodsDetailPresenter @Inject constructor() : BasePresenter<GoodsDetailView>() {

    @Inject
    lateinit var goodsService: GoodsServices

    @Inject
    lateinit var cartService: CartService

    /*
        获取商品详情
     */
    fun getGoodsDetailList(goodsId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsDetail(goodsId).execute(lifecycleProvider, object : BaseSubscriber<Goods>(mView) {
            override fun onNext(t: Goods) {
                mView.onGetGoodsDetailResult(t)
            }
        })

    }

    /*
        加入购物车
     */
    fun addCart(
        goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
        goodsCount: Int, goodsSku: String
    ) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.addCart(
            goodsId, goodsDesc, goodsIcon, goodsPrice,
            goodsCount, goodsSku
        ).execute(lifecycleProvider, object : BaseSubscriber<Int>(mView) {
            override fun onNext(t: Int) {
                AppPrefsUtils.putInt(GoodsConstant.SP_CART_SIZE, t)
                mView.onAddCartResult(t)
            }
        })

    }

}
