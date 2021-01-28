package com.betterzw.wanandroid.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.betterzw.wanandroid.R
import com.betterzw.wanandroid.databinding.ActivityAboutBinding
import com.betterzw.wanandroid.databinding.ActivityMainBinding
import com.betterzw.wanandroid.ui.base.BaseActivity

class AboutActivity : BaseActivity(){

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

   /* override fun getLayoutId() = R.layout.activity_about

    override fun initView() {
        TODO("Not yet implemented")
    }
*/
}