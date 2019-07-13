package com.odbpo.fenggo.goodscenter.presenter.view

import com.odbpo.fenggo.base_library.presenter.view.BaseView
import com.odbpo.fenggo.goodscenter.data.protocol.Goods

interface GoodsListView:BaseView {

    fun onGetGoodsListResult(result:MutableList<Goods>?)

}