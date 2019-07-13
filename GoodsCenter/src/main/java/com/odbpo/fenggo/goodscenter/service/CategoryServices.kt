package com.odbpo.fenggo.goodscenter.service

import com.kotlin.goods.data.protocol.Category
import rx.Observable


interface CategoryServices {

    fun getCategory(parentId:Int): Observable<MutableList<Category>?>

}