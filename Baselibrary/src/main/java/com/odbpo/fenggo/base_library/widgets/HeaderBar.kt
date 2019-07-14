package com.odbpo.fenggo.base_library.widgets

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.odbpo.fenggo.base_library.R
import com.odbpo.fenggo.base_library.ext.onClick
import kotlinx.android.synthetic.main.layout_header_bar.view.*


class HeaderBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var isShowBack = true
    private var titleText:String? = null
    private var rightText:String? = null

    init {
        val ta = context.obtainStyledAttributes(attrs,R.styleable.HeaderBar)
        isShowBack = ta.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        titleText = ta.getString(R.styleable.HeaderBar_titleText)
        rightText = ta.getString(R.styleable.HeaderBar_rightText)

        initView()
    }

    private fun initView() {
        View.inflate(context,R.layout.layout_header_bar,this)

        mLeftIv.visibility = if(isShowBack) View.VISIBLE else View.GONE

        titleText?.let {
            mTitleTv.text = it
        }

        rightText?.let {
            mRightTv.text = it
            mRightTv.visibility = View.VISIBLE
        }

        //返回键统一处理，如果需要特殊处理的请通过下面暴露的方法获取资源id处理
        mLeftIv.onClick {
            if(context is Activity){
                (context as Activity).finish()
            }
        }

    }

    //暴露获取资源id方法
    fun getLeftView():ImageView{
        return mLeftIv
    }

    fun getRightView():TextView{
        return mRightTv
    }

    fun getTitleView():TextView{
        return mTitleTv
    }

    /*
        获取右侧文字
     */
    fun getRightText():String{
        return mRightTv.text.toString()
    }
}