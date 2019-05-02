package com.odbpo.fenggo.kotlin_project.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.odbpo.fenggo.kotlin_project.R
import com.odbpo.fenggo.user.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_register.setOnClickListener {
//            val intent = Intent(this,RegisterActivity::class.java)
//            startActivity(intent)

//            startActivity(intentFor<RegisterActivity>("id" to 5))

            startActivity<RegisterActivity>("id" to 5)
        }
    }
}
