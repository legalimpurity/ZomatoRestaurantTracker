package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.android.databinding.library.baseAdapters.BR
import android.view.View
import com.legalimpurity.zomatorestauranttracker.R
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.databinding.FragmentRestaurantDetailBinding
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseFragment
import com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.RestaurantDetailActivity
import kotlinx.android.synthetic.main.fragment_restaurant_detail.view.*
import javax.inject.Inject

class RestaurantDetailFragment : BaseFragment<FragmentRestaurantDetailBinding, RestaurantDetailFragmentModel>(), RestaurantDetailFragmentNavigator {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

//    @Inject
//    lateinit var mAttTimeMixManager : RecyclerView.LayoutManager

//    @Inject
//    lateinit var mItemAnimator : RecyclerView.ItemAnimator

//    @Inject
//    lateinit var mTimeTableAdapter: TimeTableAdapter

//    @Inject
//    lateinit var mItemDecorator : RecyclerView.ItemDecoration

    private var mRestaurantDetailFragmentModel: RestaurantDetailFragmentModel? = null
    private var mFragmentRestaurantDetailBinding: FragmentRestaurantDetailBinding? = null

    private var restaurant:Restaurant? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentRestaurantDetailBinding = getViewDataBinding()
        mRestaurantDetailFragmentModel?.setNavigator(this)
        loadObj(arguments)
    }

    private fun loadObj(bundle: Bundle?) {
        restaurant = bundle?.getParcelable(ARG_RESTAURANT_OBJ)
        restaurant?.let {
            view?.section_label?.text = it.name
        }
    }

    //Functions to be implemented by every Fragment
    override fun getViewModel(): RestaurantDetailFragmentModel
    {
        mRestaurantDetailFragmentModel = ViewModelProviders.of(this, mViewModelFactory).get(RestaurantDetailFragmentModel::class.java!!)
        return mRestaurantDetailFragmentModel as RestaurantDetailFragmentModel
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_restaurant_detail

    override fun apiError(throwable: Throwable) {
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        val rootView = inflater.inflate(R.layout.fragment_restaurant_detail, container, false)
//
//        return rootView
//    }

    companion object {
        private val ARG_RESTAURANT_OBJ = "ARG_RESTAURANT_OBJ"
        fun newInstance(restaurant: Restaurant?): RestaurantDetailFragment {
            val fragment = RestaurantDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_RESTAURANT_OBJ, restaurant)
            fragment.arguments = args
            return fragment
        }
    }
}