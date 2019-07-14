package com.odbpo.fenggo.goodscenter.presenter

import com.odbpo.fenggo.base_library.ext.execute
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.goodscenter.data.protocol.Goods
import com.odbpo.fenggo.goodscenter.presenter.view.GoodsListView
import com.odbpo.fenggo.goodscenter.service.GoodsServices
import javax.inject.Inject

class GoodsListPresenter @Inject constructor() : BasePresenter<GoodsListView>() {

    @Inject
    lateinit var goodsServices: GoodsServices

    fun getGoodsList(categoryId: Int, pageNo: Int) {
        /**
         * 业务逻辑
         */
        //val userServices = UserServiceImpl()

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsServices.getGoodsList(categoryId,pageNo)
            .execute(lifecycleProvider, object : BaseSubscriber<MutableList<Goods>?>(mView) {
                override fun onNext(t: MutableList<Goods>?) {
                    mView.onGetGoodsListResult(t)
                }
            })

    }

    fun getGoodsListByKeyWord(keyWord: String, pageNo: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsServices.getGoodsListByKeyWord(keyWord,pageNo)
            .execute(lifecycleProvider, object : BaseSubscriber<MutableList<Goods>?>(mView) {
                override fun onNext(t: MutableList<Goods>?) {
                    mView.onGetGoodsListResult(t)
                }
            })

    }

}