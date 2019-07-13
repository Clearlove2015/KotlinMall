package com.odbpo.fenggo.goodscenter.service.impl

import com.odbpo.fenggo.base_library.ext.convert
import com.odbpo.fenggo.goodscenter.data.protocol.Goods
import com.odbpo.fenggo.goodscenter.data.repository.GoodsRepository
import com.odbpo.fenggo.goodscenter.service.GoodsServices
import rx.Observable
import javax.inject.Inject

class GoodsServiceImpl @Inject constructor():GoodsServices {

    @Inject
    lateinit var repository:GoodsRepository

    override fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsList(categoryId,pageNo)
            .convert()
    }

}