package com.odbpo.fenggo.user.ui.activity

import android.os.Bundle
import android.view.View
import com.odbpo.fenggo.base_library.common.AppManager
import com.odbpo.fenggo.base_library.ext.enable
import com.odbpo.fenggo.base_library.ext.onClick
import com.odbpo.fenggo.base_library.ui.activity.BaseMVPActivity
import com.odbpo.fenggo.user.R
import com.odbpo.fenggo.user.injection.component.DaggerUserComponent
import com.odbpo.fenggo.user.injection.module.UserModule
import com.odbpo.fenggo.user.presenter.RegisterPresenter
import com.odbpo.fenggo.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

/**
 * 注册界面
 */
class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //mPresenter = RegisterPresenter()//用Dagger注入就不需要手动实例化

        initView()
    }

    /**
     * 初始化视图
     */
    private fun initView() {
        mRegisterBtn.enable(mMobileEt, { isBtnEnable() })
        mRegisterBtn.enable(mVerifyCodeEt, { isBtnEnable() })
        mRegisterBtn.enable(mPwdEt, { isBtnEnable() })
        mRegisterBtn.enable(mPwdConfirmEt, { isBtnEnable() })

        mVerifyCodeBtn.onClick(this)
        mRegisterBtn.onClick(this)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder()
            .activityComponent(activityComponent)
            .userModule(UserModule())
            .build()
            .inject(this)

        mPresenter.mView = this
    }

    /**
     * 注册回调
     */
    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onError(text: String) {
        toast(text)
    }

    private var pressTime: Long = 0

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再按一次退出程序")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证码成功")
            }
            R.id.mRegisterBtn -> {
                mPresenter.register(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
            }
        }
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeBtn.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not();
    }

}
