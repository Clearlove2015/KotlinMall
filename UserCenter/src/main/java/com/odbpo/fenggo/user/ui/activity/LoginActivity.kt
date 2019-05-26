package com.odbpo.fenggo.user.ui.activity

import android.os.Bundle
import android.view.View
import com.odbpo.fenggo.base_library.common.AppManager
import com.odbpo.fenggo.base_library.ext.enable
import com.odbpo.fenggo.base_library.ext.onClick
import com.odbpo.fenggo.base_library.ui.activity.BaseMVPActivity
import com.odbpo.fenggo.user.R
import com.odbpo.fenggo.user.data.protocol.UserInfo
import com.odbpo.fenggo.user.injection.component.DaggerUserComponent
import com.odbpo.fenggo.user.injection.module.UserModule
import com.odbpo.fenggo.user.presenter.LoginPresenter
import com.odbpo.fenggo.user.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 登录界面
 */
class LoginActivity : BaseMVPActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //mPresenter = LoginPresenter()//用Dagger注入就不需要手动实例化

        initView()
    }

    /**
     * 初始化视图
     */
    private fun initView() {
        mLoginBtn.enable(mMobileEt, { isBtnEnable() })
        mLoginBtn.enable(mPwdEt, { isBtnEnable() })

        mLoginBtn.onClick(this)
        mForgetPwdTv.onClick(this)

        //mHeaderBar.mRightTv.onClick(this)//此处不能直接引用内部资源,只能获取到activity_login.xml中的id
        mHeaderBar.getRightView().onClick(this)//需要通过自定义控件暴露的方法获取资源id
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
     * 登录回调
     */
    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")
    }

    override fun onError(text: String) {
        toast(text)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mRightTv -> {
                startActivity<RegisterActivity>()
            }
            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(), mPwdEt.text.toString(), "")
            }
            R.id.mForgetPwdTv -> {
                startActivity<ForgetPwdActivity>()
            }
        }
    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }

    /**
     * 双击退出
     */
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

}
