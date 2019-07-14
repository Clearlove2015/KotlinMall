package com.odbpo.fenggo.goodscenter.service

import com.odbpo.fenggo.goodscenter.data.protocol.Goods
import rx.Observable


interface GoodsServices {

    fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?>

    fun getGoodsListByKeyWord(keyWord: String, pageNo: Int): Observable<MutableList<Goods>?>

    fun getGoodsDetail(goodsId: Int): Observable<Goods>

}