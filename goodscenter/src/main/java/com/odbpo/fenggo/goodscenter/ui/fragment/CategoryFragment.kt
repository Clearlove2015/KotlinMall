package com.odbpo.fenggo.goodscenter.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kennyc.view.MultiStateView
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.ui.adapter.SecondCategoryAdapter
import com.kotlin.goods.ui.adapter.TopCategoryAdapter
import com.odbpo.fenggo.base_library.ui.fragment.BaseMVPFragment
import com.odbpo.fenggo.goodscenter.R
import com.odbpo.fenggo.goodscenter.injection.component.DaggerCategoryComponent
import com.odbpo.fenggo.goodscenter.injection.module.CategoryModule
import com.odbpo.fenggo.goodscenter.presenter.CategoryPresenter
import com.odbpo.fenggo.goodscenter.presenter.view.CategoryView
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment:BaseMVPFragment<CategoryPresenter>(),CategoryView {

    //一级分类Adapter
    lateinit var topAdapter: TopCategoryAdapter
    //二级分类Adapter
    lateinit var secondAdapter: SecondCategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater.inflate(R.layout.fragment_category,container,false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        loadData()
    }

    /*
        初始化视图
     */
    private fun initView() {

        mTopCategoryRv.layoutManager = LinearLayoutManager(context)
        topAdapter = TopCategoryAdapter(context!!)
        mTopCategoryRv.adapter = topAdapter
        //单项点击事件
        topAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Category> {
            override fun onItemClick(item: Category, position: Int) {
                for (category in topAdapter.dataList) {
                    category.isSelected = item.id == category.id
                }
                topAdapter.notifyDataSetChanged()

                loadData(item.id)
            }
        })

        mSecondCategoryRv.layoutManager = GridLayoutManager(context, 3)
        secondAdapter = SecondCategoryAdapter(context!!)
        mSecondCategoryRv.adapter = secondAdapter
        secondAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Category> {
            override fun onItemClick(item: Category, position: Int) {
                //startActivity<GoodsActivity>(GoodsConstant.KEY_CATEGORY_ID  to item.id)
            }
        })

    }

    private fun loadData(parentId:Int = 0) {
        mPresenter.getCategory(parentId)
    }

    override fun onGetCategoryResult(result: MutableList<Category>?) {
        result?.let {
            if(result[0].parentId == 0){
                topAdapter.setData(result)
                result[0].isSelected = true
                mPresenter.getCategory(result[0].id)
            }else{
                secondAdapter.setData(result)
                mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT//多视图修改状态->显示内容
            }
        }
    }

    override fun injectComponent() {
        DaggerCategoryComponent.builder()
            .activityComponent(activityComponent)
            .categoryModule(CategoryModule())
            .build()
            .inject(this)

        mPresenter.mView = this
    }

}