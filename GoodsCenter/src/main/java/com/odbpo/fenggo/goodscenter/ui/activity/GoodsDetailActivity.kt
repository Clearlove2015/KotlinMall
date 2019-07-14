package com.odbpo.fenggo.goodscenter.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import com.odbpo.fenggo.base_library.ui.activity.BaseActivity
import com.odbpo.fenggo.goodscenter.R
import com.odbpo.fenggo.goodscenter.ui.adapter.GoodsDetailVpAdapter
import kotlinx.android.synthetic.main.activity_goods_detail.*

class GoodsDetailActivity:BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_detail)
        initView()
    }

    private fun initView() {
        mGoodsDetailTab.tabMode = TabLayout.MODE_FIXED
        mGoodsDetailVp.adapter = GoodsDetailVpAdapter(supportFragmentManager,this)

        mGoodsDetailTab.setupWithViewPager(mGoodsDetailVp)
    }

}