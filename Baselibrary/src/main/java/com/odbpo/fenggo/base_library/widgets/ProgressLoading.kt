package com.odbpo.fenggo.base_library.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.odbpo.fenggo.base_library.R
import org.jetbrains.anko.find

class ProgressLoading private constructor(context: Context, theme:Int):Dialog(context,theme) {

    companion object {
        private lateinit var mDialog:ProgressLoading
        private var animDrawable:AnimationDrawable? = null

        fun create(context: Context):ProgressLoading{
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)//是否可以取消
            mDialog.setCanceledOnTouchOutside(false)//点击外面是否可取消
            mDialog.window.attributes.gravity = Gravity.CENTER//居中

            val lp = mDialog.window.attributes
            lp.dimAmount = 0.2f//设置灰暗程度

            mDialog.window.attributes = lp

            val loadingView = mDialog.find<ImageView>(R.id.iv_loading)
            animDrawable = loadingView.background as AnimationDrawable

            return mDialog
        }
    }

    fun showLoading(){
        super.show()
        animDrawable?.start()
    }

    fun hideLoading(){
        super.dismiss()
        animDrawable?.stop()
    }

}