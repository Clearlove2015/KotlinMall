package com.odbpo.fenggo.user

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.odbpo.fenggo.base_library.ui.activity.BaseMVPActivity
import com.odbpo.fenggo.user.injection.component.DaggerUserComponent
import com.odbpo.fenggo.user.injection.module.UserModule
import com.odbpo.fenggo.user.presenter.RegisterPresenter
import com.odbpo.fenggo.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView {

    override fun onRegisterResult(result: Boolean) {
        if(result){
            toast("注册成功")
        }else{
            toast("注册失败")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initInject()

        //mPresenter = RegisterPresenter()//用Dagger注入就不需要手动实例化

        btn_register.setOnClickListener {
            //toast("${intent.getIntExtra("id", -1)}")
            mPresenter.register(et_name.text.toString(),et_sms.text.toString(),et_psd.text.toString())
        }

        btn_register2.setOnClickListener {
            //toast("${intent.getIntExtra("id", -1)}")
            //mPresenter.register2(et_name.text.toString(),et_sms.text.toString(),et_psd.text.toString())
        }
    }

    private fun initInject() {
        DaggerUserComponent.builder()
            .activityComponent(activityComponent)
            .userModule(UserModule())
            .build()
            .inject(this)

        mPresenter.mView = this
    }
}
