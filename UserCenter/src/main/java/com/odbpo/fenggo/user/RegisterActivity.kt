package com.odbpo.fenggo.user

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.odbpo.fenggo.base_library.ui.activity.BaseMVPActivity
import com.odbpo.fenggo.user.presenter.RegisterPresenter
import com.odbpo.fenggo.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView {

    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mPresenter = RegisterPresenter()
        mPresenter.mView = this

        btn_register.setOnClickListener {
            //toast("${intent.getIntExtra("id", -1)}")
            mPresenter.register("","","")
        }
    }
}
