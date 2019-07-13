package com.odbpo.fenggo.goodscenter.presenter

import com.kotlin.goods.data.protocol.Category
import com.odbpo.fenggo.base_library.ext.execute
import com.odbpo.fenggo.base_library.presenter.BasePresenter
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.goodscenter.presenter.view.CategoryView
import com.odbpo.fenggo.goodscenter.service.CategoryServices
import javax.inject.Inject

class CategoryPresenter @Inject constructor() : BasePresenter<CategoryView>() {

    @Inject
    lateinit var categoryServices: CategoryServices

    fun getCategory(parentId:Int) {
        /**
         * 业务逻辑
         */
        //val userServices = UserServiceImpl()

        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        categoryServices.getCategory(parentId)
            .execute(lifecycleProvider, object : BaseSubscriber<MutableList<Category>?>(mView) {
                override fun onNext(t: MutableList<Category>?) {
                    mView.onGetCategoryResult(t)
                }
            })

    }

}