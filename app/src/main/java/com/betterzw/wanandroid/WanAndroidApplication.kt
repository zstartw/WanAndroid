package com.betterzw.wanandroid

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WanAndroidApplication : Application(){

   /* override fun onCreate() {
        super.onCreate()

        //初始化日记模块
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .methodCount(0)
            .methodOffset(7)
            .tag("WanAndroid >>> ")
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }


    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)

        //清除缓存
    }

    override fun onLowMemory() {
        super.onLowMemory()
        //清除缓存
    }*/
}