package com.odbpo.fenggo.goodscenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.odbpo.fenggo.base_library.ui.fragment.BaseFragment
import com.odbpo.fenggo.goodscenter.R

class GoodsDetailTabTwoFragment:BaseFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater.inflate(R.layout.fragment_goods_detail_tab_two,container,false)
        return rootView
    }

}