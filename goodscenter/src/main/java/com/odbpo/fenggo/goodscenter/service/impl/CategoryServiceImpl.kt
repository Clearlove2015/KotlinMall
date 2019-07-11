package com.odbpo.fenggo.goodscenter.service.impl

import com.kotlin.goods.data.protocol.Category
import com.odbpo.fenggo.base_library.ext.convert
import com.odbpo.fenggo.goodscenter.data.repository.CategoryRepository
import com.odbpo.fenggo.goodscenter.service.CategoryServices
import rx.Observable
import javax.inject.Inject

class CategoryServiceImpl @Inject constructor():CategoryServices {

    @Inject
    lateinit var repository:CategoryRepository

    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return repository.getCategory(parentId)
            .convert()
    }

}