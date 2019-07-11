package com.odbpo.fenggo.kotlin_project.ui.activity

import android.os.Bundle
import com.kotlin.user.utils.UserPrefsUtils
import com.odbpo.fenggo.base_library.ext.onClick
import com.odbpo.fenggo.base_library.ui.activity.BaseActivity
import com.odbpo.fenggo.kotlin_project.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity:BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        //退出登录
        mLogoutBtn.onClick {
            UserPrefsUtils.putUserInfo(null)
            finish()
        }
    }

}