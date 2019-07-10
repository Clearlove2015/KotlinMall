package com.odbpo.fenggo.kotlin_project.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.widgets.BannerImageLoader
import com.kotlin.mall.common.*
import com.odbpo.fenggo.base_library.ui.fragment.BaseFragment
import com.odbpo.fenggo.kotlin_project.R
import com.odbpo.fenggo.kotlin_project.ui.adapter.HomeDiscountAdapter
import com.odbpo.fenggo.kotlin_project.ui.adapter.TopicAdapter
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*
import me.crosswall.lib.coverflow.CoverFlow

class HomeFragment:BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater.inflate(R.layout.fragment_home,null)
        //在Fragment中使用kotlin-android-extensions时，onCreateView（）方法中无法拿到id，需要在onViewCreated（）方法中调用
        //initBanner()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //视图渲染完成后再取id
        initBanner()
        initNews()
        initDiscount()
        initTopic()
    }

    private fun initBanner() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        mHomeBanner.setBannerAnimation(Transformer.Accordion)
        mHomeBanner.setDelayTime(2000)
        //设置指示器位置（当Banner模式中有指示器时）
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT)
        //banner设置方法全部调用完毕时最后调用
        mHomeBanner.start()
    }

    private fun initNews(){
        mNewsFlipperView.setData(arrayOf("夏日炎炎，第一波福利还有30秒到达战场", "新用户立刻领1000元优惠券"))
    }

    private fun initDiscount(){
        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        mHomeDiscountRv.layoutManager = manager

        val discountAdapter = HomeDiscountAdapter(activity!!)
        mHomeDiscountRv.adapter = discountAdapter
        discountAdapter.setData(mutableListOf(HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE,
            HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE))
    }

    private fun initTopic(){
        //话题
        mTopicPager.adapter = TopicAdapter(context!!, listOf(HOME_TOPIC_ONE, HOME_TOPIC_TWO, HOME_TOPIC_THREE, HOME_TOPIC_FOUR, HOME_TOPIC_FIVE))
        mTopicPager.currentItem = 1
        mTopicPager.offscreenPageLimit = 5

        CoverFlow.Builder().with(mTopicPager).scale(0.3f).pagerMargin(-30.0f).spaceSize(0.0f).build()
    }
}