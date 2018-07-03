package com.legalimpurity.zomatorestauranttracker.ui.mainview

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.android.databinding.library.baseAdapters.BR
import com.legalimpurity.zomatorestauranttracker.R
import com.legalimpurity.zomatorestauranttracker.databinding.ActivityMainBinding
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainActivityNavigator {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private var mMainViewModel: MainViewModel? = null

    private var mActivityMainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainViewModel?.setNavigator(this)
        mActivityMainBinding = getViewDataBinding()
    }

    // Functions to be implemented by every Activity
    override fun getViewModel(): MainViewModel {
        mMainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java!!)
        return mMainViewModel as MainViewModel
    }

    override fun getBindingVariable() = BR.viewModel

    override fun getLayoutId() = R.layout.activity_main

    override fun getCoordinatorRootLayout() = mActivityMainBinding?.rootCoordinator

    // Navigator Functions

    override fun apiError(throwable: Throwable) {
    }

}
