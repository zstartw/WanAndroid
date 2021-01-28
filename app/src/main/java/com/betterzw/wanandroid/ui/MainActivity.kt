package com.betterzw.wanandroid.ui

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.betterzw.wanandroid.HomeFragment
import com.betterzw.wanandroid.R
import com.betterzw.wanandroid.TypeFragment
import com.betterzw.wanandroid.databinding.ActivityMainBinding
import com.betterzw.wanandroid.ui.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(){


    private var homeFragment: HomeFragment? = null
    private var typeFragment: TypeFragment? = null

    private val mFragmentManager by lazy {
        supportFragmentManager
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigationView.run {
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            selectedItemId = R.id.navigation_home
        }
    }


    /**
     * NavigationItemSelect监听
     */
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            setFragment(item.itemId)
            return@OnNavigationItemSelectedListener when (item.itemId) {
                R.id.navigation_home -> {
//                    if (currentIndex == R.id.navigation_home) {
//                        homeFragment?.smoothScrollToPosition()
//                    }
//                    currentIndex = R.id.navigation_home

                    true
                }
                R.id.navigation_type -> {
//                    if (currentIndex == R.id.navigation_type) {
//                        typeFragment?.smoothScrollToPosition()
//                    }
//                    currentIndex = R.id.navigation_type
                    true
                }
                else -> {
                    false
                }
            }
        }

    /**
     * 显示对应Fragment
     */
    private fun setFragment(index: Int) {

        mFragmentManager.beginTransaction().apply {
            homeFragment ?: let {
                HomeFragment().let {
                    homeFragment = it
                    add(R.id.nav_host_container, it)
                }
            }
            typeFragment ?: let {
                TypeFragment().let {
                    typeFragment = it
                    add(R.id.nav_host_container, it)
                }
            }

            hideFragment(this)
            when (index) {
                R.id.navigation_home -> {
                    homeFragment?.let {
                        this.show(it)
                    }
                }
                R.id.navigation_type -> {
                    typeFragment?.let {
                        this.show(it)
                    }
                }
            }
        }.commit()
    }

    /**
     * 隐藏所有fragment
     */
    private fun hideFragment(transaction: FragmentTransaction) {
        homeFragment?.let {
            transaction.hide(it)
        }
        typeFragment?.let {
            transaction.hide(it)
        }
    }


 /*   override fun getLayoutId() =  R.layout.activity_main

    override fun initView() {
        Logger.d("initView");

//        if (BuildConfig.DEBUG){
//            startActivity<SplashActivity>()
//        }
    }


    override fun initData() {
//        super.initData()

    }*/



}