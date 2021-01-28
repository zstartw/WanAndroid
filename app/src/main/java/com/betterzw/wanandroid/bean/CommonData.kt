package com.betterzw.wanandroid.bean


data class CommonData(
    var offset: Int,
    var size: Int,
    var total: Int,
    var pageCount: Int,
    var curPage: Int,
    var over: Boolean,
    var datas: List<HomeListItem>
)