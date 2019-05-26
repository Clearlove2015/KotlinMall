package com.odbpo.fenggo.user.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.TResult
import com.kotlin.base.utils.DateUtils
import com.odbpo.fenggo.base_library.ext.onClick
import com.odbpo.fenggo.base_library.ui.activity.BaseMVPActivity
import com.odbpo.fenggo.user.R
import com.odbpo.fenggo.user.injection.component.DaggerUserComponent
import com.odbpo.fenggo.user.injection.module.UserModule
import com.odbpo.fenggo.user.presenter.UserInfoPresenter
import com.odbpo.fenggo.user.presenter.view.UserInfoView
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.toast
import java.io.File


/**
 * 用户信息界面
 */
class UserInfoActivity : BaseMVPActivity<UserInfoPresenter>(), UserInfoView, View.OnClickListener,TakePhoto.TakeResultListener {

    private lateinit var mTakePhoto:TakePhoto

    private lateinit var mTempFile:File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.odbpo.fenggo.user.R.layout.activity_user_info)

        mTakePhoto = TakePhotoImpl(this,this)
        mTakePhoto.onCreate(savedInstanceState)
        initView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode,resultCode,data)
    }

    /**
     * 初始化视图
     */
    private fun initView() {
        mUserIconView.onClick(this)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder()
            .activityComponent(activityComponent)
            .userModule(UserModule())
            .build()
            .inject(this)

        mPresenter.mView = this
    }

    override fun onError(text: String) {
        toast(text)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mUserIconView -> {
                showAlertView()
            }
        }
    }

    private fun showAlertView() {
        AlertView("选择图片", null, "取消", null,
            arrayOf("拍照", "相册"),
            this, AlertView.Style.ActionSheet, object : OnItemClickListener {
                override fun onItemClick(o: Any?, position: Int) {
                    mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(),false)
                    when (position) {
                        0 -> {
                            createTempFile()
                            mTakePhoto.onPickFromCapture(Uri.fromFile(mTempFile))//拍照
                        }
                        1 -> mTakePhoto.onPickFromGallery()//从相册选取图片
                    }
                }
            }).show()
    }

    //图片获取成功
    override fun takeSuccess(result: TResult?) {
        Log.d("TakePhoto",result?.image?.originalPath)//原始图片地址
        Log.d("TakePhoto",result?.image?.compressPath)//压缩图片地址
    }

    //取消
    override fun takeCancel() {

    }

    //图片获取失败
    override fun takeFail(result: TResult?, msg: String?) {
        Log.d("TakePhoto",msg)
    }

    fun createTempFile(){
        val tempFileName = "${DateUtils.curTime}.png"
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            mTempFile = File(Environment.getExternalStorageDirectory(),tempFileName)
            return
        }
        mTempFile = File(filesDir,tempFileName)
    }

}
