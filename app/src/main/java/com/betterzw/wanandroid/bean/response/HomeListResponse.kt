package com.betterzw.wanandroid.bean.response

import com.betterzw.wanandroid.bean.CommonData
import com.google.gson.annotations.SerializedName

data class HomeListResponse(

    @field:SerializedName("data") val data: CommonData


//    var errorCode: Int,
//    var errorMsg: String?,
//    var data: Data
)