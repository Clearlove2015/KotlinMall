package com.odbpo.fenggo.user.data.protocol

data class ResetPwdReq(
    val mobile: String,
    val pwd: String
)