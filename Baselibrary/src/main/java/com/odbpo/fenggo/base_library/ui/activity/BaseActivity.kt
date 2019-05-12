package com.odbpo.fenggo.base_library.ui.activity

import android.os.Bundle
import com.odbpo.fenggo.base_library.common.AppManager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

open class BaseActivity :RxAppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }

}