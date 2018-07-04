package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.android.databinding.library.baseAdapters.BR
import android.view.View
import com.legalimpurity.zomatorestauranttracker.R
import com.legalimpurity.zomatorestauranttracker.databinding.FragmentRestaurantDetailBinding
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseFragment
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentRestaurantDetailBinding = getViewDataBinding()
        mRestaurantDetailFragmentModel?.setNavigator(this)
        view.section_label.text = getString(R.string.section_format, arguments?.getInt(ARG_SECTION_NUMBER))
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
        private val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(sectionNumber: Int): RestaurantDetailFragment {
            val fragment = RestaurantDetailFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}