package com.odbpo.fenggo.kotlin_project.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.common.ProviderConstant
import com.odbpo.fenggo.base_library.ext.loadUrl
import com.odbpo.fenggo.base_library.ext.onClick
import com.odbpo.fenggo.base_library.ui.fragment.BaseFragment
import com.odbpo.fenggo.kotlin_project.R
import com.odbpo.fenggo.kotlin_project.ui.activity.SettingActivity
import com.odbpo.fenggo.provider.common.isLogin
import com.odbpo.fenggo.user.ui.activity.UserInfoActivity
import kotlinx.android.synthetic.main.fragment_me.*
import org.jetbrains.anko.support.v4.startActivity

class MeFragment:BaseFragment(),View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater.inflate(R.layout.fragment_me,null)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mUserIconIv.onClick(this)
        mUserNameTv.onClick(this)
        mSettingTv.onClick(this)
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    private fun loadData() {
        if(isLogin()){
            mUserIconIv.setImageResource(R.drawable.icon_default_user)
            mUserNameTv.text = getString(R.string.un_login_text)
        }else{
            val userIcon = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
            if(userIcon.isNotEmpty()){
                mUserIconIv.loadUrl(userIcon)
            }
            mUserNameTv.text = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        }
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.mUserIconIv,R.id.mUserNameTv->{
                if(isLogin()){
                    startActivity<UserInfoActivity>()
                }else{
                    //startActivity<LoginActivity>()
                    startActivity<UserInfoActivity>()
                }
            }
            R.id.mSettingTv->{
                startActivity<SettingActivity>()
            }
        }
    }

}