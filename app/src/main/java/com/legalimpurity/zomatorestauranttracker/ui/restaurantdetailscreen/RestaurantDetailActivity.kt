package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.design.widget.Snackbar

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.android.databinding.library.baseAdapters.BR

import com.legalimpurity.zomatorestauranttracker.R
import com.legalimpurity.zomatorestauranttracker.databinding.ActivityRestaurantDetailBinding
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseActivity
import com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment.RestaurantDetailFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_restaurant_detail.*
import javax.inject.Inject

class RestaurantDetailActivity : BaseActivity<ActivityRestaurantDetailBinding, RestaurantDetailModel>(), RestaurantDetailNavigator, HasSupportFragmentInjector {

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"
        fun launchRestaurantDetailActivity(activity: AppCompatActivity) {
            val intent = Intent()
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRestaurantDetailModel?.setNavigator(this)
        mActivityRestaurantDetailBinding = getViewDataBinding()

        setSupportActionBar(toolbar)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        container.adapter = mSectionsPagerAdapter

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_restaurant_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return RestaurantDetailFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            return 3
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
