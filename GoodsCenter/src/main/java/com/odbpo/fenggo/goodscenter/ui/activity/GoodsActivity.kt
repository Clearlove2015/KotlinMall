package com.odbpo.fenggo.goodscenter.ui.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder
import cn.bingoogolapple.refreshlayout.BGARefreshLayout
import com.kennyc.view.MultiStateView
import com.odbpo.fenggo.base_library.ext.startLoading
import com.odbpo.fenggo.base_library.ui.activity.BaseMVPActivity
import com.odbpo.fenggo.goodscenter.R
import com.odbpo.fenggo.goodscenter.common.GoodsConstant
import com.odbpo.fenggo.goodscenter.data.protocol.Goods
import com.odbpo.fenggo.goodscenter.injection.component.DaggerGoodsComponent
import com.odbpo.fenggo.goodscenter.injection.module.GoodsModule
import com.odbpo.fenggo.goodscenter.presenter.GoodsListPresenter
import com.odbpo.fenggo.goodscenter.presenter.view.GoodsListView
import com.odbpo.fenggo.goodscenter.ui.adapter.GoodsAdapter
import kotlinx.android.synthetic.main.activity_goods.*

class GoodsActivity : BaseMVPActivity<GoodsListPresenter>(), GoodsListView, BGARefreshLayout.BGARefreshLayoutDelegate {

    private lateinit var goodsAdapter: GoodsAdapter

    private var mCurrentPage: Int = 1
    private var mMaxPage: Int = 1

    private var mData: MutableList<Goods>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)
        initView()
        initRefreshLayout()
        loadData()
    }

    private fun initView() {
        mGoodsRv.layoutManager = GridLayoutManager(this, 2)
        goodsAdapter = GoodsAdapter(this)
        mGoodsRv.adapter = goodsAdapter
    }

    //初始化BGARefreshLayout
    private fun initRefreshLayout() {
        mRefreshLayout.setDelegate(this)
        var viewHolder = BGANormalRefreshViewHolder(this, true)
        viewHolder.setLoadMoreBackgroundColorRes(R.color.common_bg)
        viewHolder.setRefreshViewBackgroundColorRes(R.color.common_bg)
        mRefreshLayout.setRefreshViewHolder(viewHolder)
    }

    private fun loadData() {
        if (intent.getIntExtra(GoodsConstant.KEY_SEARCH_GOODS_TYPE, 0) != 0) {
            mMultiStateView.startLoading()
            mPresenter.getGoodsListByKeyWord(intent.getStringExtra(GoodsConstant.KEY_GOODS_KEYWORD), mCurrentPage)
        } else {
            mMultiStateView.startLoading()
            mPresenter.getGoodsList(intent.getIntExtra(GoodsConstant.KEY_CATEGORY_ID, 1), mCurrentPage)
        }
    }

    override fun injectComponent() {
        DaggerGoodsComponent.builder()
            .activityComponent(activityComponent)
            .goodsModule(GoodsModule())
            .build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun onGetGoodsListResult(result: MutableList<Goods>?) {
        mRefreshLayout.endLoadingMore()//结束加载
        mRefreshLayout.endRefreshing()//结束刷新
        if (result != null && result.size > 0) {
            mMaxPage = result[0].maxPage
            if (mCurrentPage == 1) {//如果当前页为第一页
                goodsAdapter.setData(result)
            } else {
                goodsAdapter.dataList.addAll(result)//在前的数据上追加
                goodsAdapter.notifyDataSetChanged()
            }

            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT//多视图修改状态->显示内容
        } else {
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY//多视图修改状态->空白页
        }
    }

    //加载更多
    override fun onBGARefreshLayoutBeginLoadingMore(refreshLayout: BGARefreshLayout?): Boolean {
        return if (mCurrentPage < mMaxPage) {
            mCurrentPage++
            loadData()
            true
        } else {
            false
        }
    }

    //刷新
    override fun onBGARefreshLayoutBeginRefreshing(refreshLayout: BGARefreshLayout?) {
        mCurrentPage = 1
        loadData()
    }

}