package com.odbpo.fenggo.kotlin_project.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.odbpo.fenggo.kotlin_project.R
import com.odbpo.fenggo.kotlin_project.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBottomNavBar.checkMsgBadge(false)
        mBottomNavBar.checkCartBadge(20)

        initView()
    }

    private fun initView() {
        val manager = supportFragmentManager.beginTransaction()
        manager.replace(R.id.mContainer,HomeFragment())
        manager.commit()
    }
}
