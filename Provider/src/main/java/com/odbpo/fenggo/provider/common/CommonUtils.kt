package com.odbpo.fenggo.provider.common

import com.kotlin.base.utils.AppPrefsUtils
import com.odbpo.fenggo.base_library.common.BaseConstant

//全局函数
fun isLogin():Boolean{
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}