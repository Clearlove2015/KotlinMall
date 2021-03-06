package com.odbpo.fenggo.goodscenter.data.repository

import com.odbpo.fenggo.base_library.data.net.RetrofitFactory
import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import com.odbpo.fenggo.goodscenter.data.api.GoodsApi
import com.odbpo.fenggo.goodscenter.data.protocol.GetGoodsDetailReq
import com.odbpo.fenggo.goodscenter.data.protocol.GetGoodsListByKeywordReq
import com.odbpo.fenggo.goodscenter.data.protocol.GetGoodsListReq
import com.odbpo.fenggo.goodscenter.data.protocol.Goods
import rx.Observable
import javax.inject.Inject

/*
    商品数据层
 */
class GoodsRepository @Inject constructor() {

    /*
        根据分类搜索商品
     */
    fun getGoodsList(categoryId: Int, pageNo: Int): Observable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.create(GoodsApi::class.java).getGoodsList(GetGoodsListReq(categoryId, pageNo))
    }

    /*
        根据关键字搜索商品
     */
    fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.create(GoodsApi::class.java).getGoodsListByKeyword(GetGoodsListByKeywordReq(keyword, pageNo))
    }

    /*
        商品详情
     */
    fun getGoodsDetail(goodsId: Int): Observable<BaseResp<Goods>> {
        return RetrofitFactory.instance.create(GoodsApi::class.java).getGoodsDetail(GetGoodsDetailReq(goodsId))
    }

}
