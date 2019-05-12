package com.odbpo.fenggo.user

import android.os.Bundle
import com.odbpo.fenggo.base_library.ext.onClick
import com.odbpo.fenggo.base_library.ui.activity.BaseMVPActivity
import com.odbpo.fenggo.user.injection.component.DaggerUserComponent
import com.odbpo.fenggo.user.injection.module.UserModule
import com.odbpo.fenggo.user.presenter.RegisterPresenter
import com.odbpo.fenggo.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //mPresenter = RegisterPresenter()//用Dagger注入就不需要手动实例化

//        btn_register.setOnClickListener {
//            //toast("${intent.getIntExtra("id", -1)}")
//            mPresenter.register(et_name.text.toString(), et_sms.text.toString(), et_psd.text.toString())
//        }

        btn_register.onClick {
            //toast("${intent.getIntExtra("id", -1)}")
            mPresenter.register(et_name.text.toString(), et_sms.text.toString(), et_psd.text.toString())
        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder()
            .activityComponent(activityComponent)
            .userModule(UserModule())
            .build()
            .inject(this)

        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

}
