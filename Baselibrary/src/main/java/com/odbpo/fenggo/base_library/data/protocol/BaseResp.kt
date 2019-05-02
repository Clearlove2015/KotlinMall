package com.odbpo.fenggo.base_library.data.protocol

class BaseResp<T>(val status:Int,val message:String,val data:T)