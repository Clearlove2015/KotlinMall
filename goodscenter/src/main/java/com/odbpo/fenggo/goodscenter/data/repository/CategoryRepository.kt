package com.odbpo.fenggo.goodscenter.data.repository

import com.kotlin.goods.data.protocol.Category
import com.odbpo.fenggo.base_library.data.net.RetrofitFactory
import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import com.odbpo.fenggo.goodscenter.data.api.CategoryApi
import com.odbpo.fenggo.goodscenter.data.protocol.GetCategoryReq
import rx.Observable
import javax.inject.Inject

class CategoryRepository @Inject constructor() {

    fun getCategory(parentId:Int): Observable<BaseResp<MutableList<Category>?>>{
        return RetrofitFactory.instance.create(CategoryApi::class.java)
            .getCategory(GetCategoryReq(parentId))
    }

}