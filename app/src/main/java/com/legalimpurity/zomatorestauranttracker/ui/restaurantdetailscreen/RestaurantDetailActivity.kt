package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.support.design.widget.Snackbar

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.android.databinding.library.baseAdapters.BR

import com.legalimpurity.zomatorestauranttracker.R
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.databinding.ActivityRestaurantDetailBinding
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseActivity
import com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment.RestaurantDetailFragment
import com.legalimpurity.zomatorestauranttracker.util.AppLogger
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_restaurant_detail.*
import java.util.ArrayList
import javax.inject.Inject

class RestaurantDetailActivity : BaseActivity<ActivityRestaurantDetailBinding, RestaurantDetailModel>(), RestaurantDetailNavigator, HasSupportFragmentInjector {

    companion object {
        private val ARG_LIST_OF_ITEMS = "ARG_LIST_OF_ITEMS"
        private val ARG_ITEM_NUMBER = "ARG_ITEM_NUMBER"
        fun launchRestaurantDetailActivity(activity: AppCompatActivity, listOfResturants: List<Restaurant?>?, selectedItemPos: Int) {
            val intent = Intent()
            intent.putParcelableArrayListExtra(ARG_LIST_OF_ITEMS,listOfResturants as ArrayList<Restaurant>)
            intent.putExtra(ARG_ITEM_NUMBER,selectedItemPos)
            intent.setClass(activity, RestaurantDetailActivity::class.java)
            activity.startActivity(intent)
        }
    }

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private var mRestaurantDetailModel: RestaurantDetailModel? = null

    private var mActivityRestaurantDetailBinding: ActivityRestaurantDetailBinding? = null

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    private var restaurantsList:ArrayList<Restaurant>? = null
    private var selectedPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRestaurantDetailModel?.setNavigator(this)
        mActivityRestaurantDetailBinding = getViewDataBinding()

        setSupportActionBar(toolbar)
        loadObj()
    }

    private fun loadObj()
    {
        if (intent.hasExtra(ARG_LIST_OF_ITEMS)) {
            restaurantsList  = intent.getParcelableArrayListExtra<Restaurant>(ARG_LIST_OF_ITEMS)
            selectedPos = intent.getIntExtra(ARG_ITEM_NUMBER,0)
            setupAdapter()
        }
    }

    private fun setupAdapter()
    {
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter
        container.setCurrentItem(selectedPos,true)
    }


    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_restaurant_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return when (id) {
            R.id.action_photos_url -> {
                restaurantsList?.get(container.currentItem)?.photosUrl?.let { openBrowser(it) }
                true
            }
            R.id.action_events_url -> {
                restaurantsList?.get(container.currentItem)?.eventsUrl?.let { openBrowser(it) }
                true
            }
            R.id.action_menu_url -> {
                restaurantsList?.get(container.currentItem)?.menuUrl?.let { openBrowser(it) }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun openBrowser(url: String)
    {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return RestaurantDetailFragment.newInstance(restaurantsList?.get(position))
        }

        override fun getCount(): Int {
            return restaurantsList?.size ?: 0
        }
    }



    override fun getViewModel(): RestaurantDetailModel {
        mRestaurantDetailModel = ViewModelProviders.of(this, mViewModelFactory).get(RestaurantDetailModel::class.java)
        return mRestaurantDetailModel as RestaurantDetailModel
    }

    override fun getBindingVariable() = BR.viewModel

    override fun getLayoutId() = R.layout.activity_restaurant_detail

    override fun getCoordinatorRootLayout() = mActivityRestaurantDetailBinding?.rootCoordinator

    override fun apiError(throwable: Throwable) {

    }

}
