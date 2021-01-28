package com.betterzw.wanandroid.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.betterzw.wanandroid.R
import com.betterzw.wanandroid.databinding.ActivityMainBinding
import com.betterzw.wanandroid.databinding.ActivityWebviewBinding
import com.betterzw.wanandroid.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebViewActivity : BaseActivity(){

    private var shareTitle: String ?= null
    private var shareUrl: String ?= null
    private var shareId: Int = 0

    private lateinit var binding: ActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.toolbar.run {
            title = getString(R.string.loading)
            setSupportActionBar(this)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        intent.extras?.let {
            shareId = it.getInt(Constant.CONTENT_ID_KEY, 0)
            shareUrl = it.getString(Constant.CONTENT_URL_KEY)
            shareTitle = it.getString(Constant.CONTENT_TITLE_KEY)
        }

        binding.webview.settings.javaScriptEnabled = true
        binding.webview.loadUrl(shareUrl ?: "")
        binding.toolbar.title = shareTitle
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}