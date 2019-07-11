package com.odbpo.fenggo.goodscenter.data.api

import com.kotlin.goods.data.protocol.Category
import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import com.odbpo.fenggo.goodscenter.data.protocol.GetCategoryReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface CategoryApi {

    @POST("category/getCategory")
    fun getCategory(@Body req: GetCategoryReq): Observable<BaseResp<MutableList<Category>?>>

}