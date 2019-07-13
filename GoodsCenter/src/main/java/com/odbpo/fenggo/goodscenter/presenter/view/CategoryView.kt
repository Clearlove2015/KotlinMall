package com.odbpo.fenggo.goodscenter.presenter.view

import com.kotlin.goods.data.protocol.Category
import com.odbpo.fenggo.base_library.presenter.view.BaseView

interface CategoryView:BaseView {

    fun onGetCategoryResult(result:MutableList<Category>?)

}