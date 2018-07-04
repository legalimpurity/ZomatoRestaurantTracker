package com.legalimpurity.zomatorestauranttracker.ui.mainview

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import com.android.databinding.library.baseAdapters.BR
import com.legalimpurity.zomatorestauranttracker.R
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.databinding.ActivityMainBinding
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseActivity
import com.legalimpurity.zomatorestauranttracker.ui.mainview.mainviewadapter.RestaurantsAdapter
import com.legalimpurity.zomatorestauranttracker.ui.mainview.mainviewadapter.RestaurantsAdapterListener
import com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.RestaurantDetailActivity
import java.lang.ref.WeakReference
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainActivityNavigator {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private var mMainViewModel: MainViewModel? = null

    private var mActivityMainBinding: ActivityMainBinding? = null

    @Inject
    lateinit var mLayoutManager : RecyclerView.LayoutManager

    @Inject
    lateinit var mItemAnimator : RecyclerView.ItemAnimator

    @Inject
    lateinit var mItemDecorator : RecyclerView.ItemDecoration

    @Inject
    lateinit var mRestaurantsAdapter: RestaurantsAdapter

    private var mRestaurantsAdapterListener : RestaurantsAdapterListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainViewModel?.setNavigator(this)
        mActivityMainBinding = getViewDataBinding()
        setUpRestaurantAdapter()
        subscribeToLiveData()
    }

    private fun setUpRestaurantAdapter()
    {
        mRestaurantsAdapterListener = object : RestaurantsAdapterListener {
            override fun onClick(restaurantItemPos: Int, context : Context) {
                RestaurantDetailActivity.launchRestaurantDetailActivity(context as AppCompatActivity,mMainViewModel?.restaurantItemsLiveData?.value,restaurantItemPos)
            }
        }

        mActivityMainBinding?.rvRestaurantsRecyclerView?.layoutManager = mLayoutManager
        mActivityMainBinding?.rvRestaurantsRecyclerView?.itemAnimator = mItemAnimator
        mActivityMainBinding?.rvRestaurantsRecyclerView?.addItemDecoration(mItemDecorator)
        mActivityMainBinding?.rvRestaurantsRecyclerView?.adapter = mRestaurantsAdapter
        mRestaurantsAdapter.restaurantsAdapterListener = mRestaurantsAdapterListener
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
        mMainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java)
        return mMainViewModel as MainViewModel
    }

    override fun getBindingVariable() = BR.viewModel

    override fun getLayoutId() = R.layout.activity_main

    override fun getCoordinatorRootLayout() = mActivityMainBinding?.rootCoordinator

    // Navigator Functions

    override fun apiError(throwable: Throwable) {
        if(throwable.localizedMessage.equals("Callable returned null") && !mInternetStateProvider.isOnline())
            showMsg(R.string.no_internet_cache_error,-1,null)
        else
            showMsg(R.string.generic_error,-1,null)
    }

    override fun checkLatLongValidation()
    {
        val latRegex = Regex("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)")
        val lonRegex = Regex("\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)")

        hideKeyboard()

        //validate latitude and longitude
        var returner = true
        if (TextUtils.isEmpty(mActivityMainBinding?.etLatitude?.text.toString())) {
            mActivityMainBinding?.etLatitude?.error = getString(R.string.error_latitude)
            returner = false
        }

        if (TextUtils.isEmpty(mActivityMainBinding?.etLongitude?.text)) {
            mActivityMainBinding?.etLongitude?.error = getString(R.string.error_longitude)
            returner = false
        }

        if (!mActivityMainBinding?.etLongitude?.text!!.matches(lonRegex)) {
            mActivityMainBinding?.etLongitude?.error = getString(R.string.error_longitude_format)
            returner = false
        }

        if (!mActivityMainBinding?.etLatitude?.text!!.matches(latRegex)) {
            mActivityMainBinding?.etLatitude?.error = getString(R.string.error_latitude_format)
            returner = false
        }

        if(returner)
            mMainViewModel?.loadRestaurantsForCoordinates()

    }

}
