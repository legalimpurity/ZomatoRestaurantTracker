package com.legalimpurity.zomatorestauranttracker.ui.mainview

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.android.databinding.library.baseAdapters.BR
import com.legalimpurity.zomatorestauranttracker.R
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.databinding.ActivityMainBinding
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseActivity
import com.legalimpurity.zomatorestauranttracker.ui.mainview.mainviewadapter.RestaurantsAdapter
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainActivityNavigator {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var mLayoutManager : RecyclerView.LayoutManager

    @Inject
    lateinit var mItemAnimator : RecyclerView.ItemAnimator

    @Inject
    lateinit var mItemDecorator : RecyclerView.ItemDecoration

    @Inject
    lateinit var mRestaurantsAdapter: RestaurantsAdapter

    private var mMainViewModel: MainViewModel? = null

    private var mActivityMainBinding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainViewModel?.setNavigator(this)
        mActivityMainBinding = getViewDataBinding()
        setUpRestaurantAdapter()
        subscribeToLiveData()
    }


    private fun setUpRestaurantAdapter()
    {
        mActivityMainBinding?.rvRestaurantsRecyclerView?.layoutManager = mLayoutManager
        mActivityMainBinding?.rvRestaurantsRecyclerView?.itemAnimator = mItemAnimator
        mActivityMainBinding?.rvRestaurantsRecyclerView?.addItemDecoration(mItemDecorator)
        mActivityMainBinding?.rvRestaurantsRecyclerView?.adapter = mRestaurantsAdapter
    }

    private fun subscribeToLiveData()
    {
        mMainViewModel?.restaurantItemsLiveData?.observe(this, Observer<List<Restaurant?>> {
            restaurantObjs -> restaurantObjs?.let{
                mMainViewModel?.restaurantItemsObservableArrayList?.clear()
            mMainViewModel?.restaurantItemsObservableArrayList?.addAll(it)
            }
        })
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
