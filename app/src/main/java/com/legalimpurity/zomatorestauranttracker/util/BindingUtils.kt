package com.legalimpurity.zomatorestauranttracker.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.widget.ImageView
import com.legalimpurity.zomatorestauranttracker.R
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Review
import com.legalimpurity.zomatorestauranttracker.ui.mainview.mainviewadapter.RestaurantsAdapter
import com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment.restaurantdetailfragmentadapter.RestaurantsReviewsAdapter
import java.util.ArrayList

@BindingAdapter("adapter")
fun restaurantsAdapterBinding(recyclerView: RecyclerView,
                              restaurants: List<Restaurant>) {
    if(recyclerView.adapter is RestaurantsAdapter) {
        val adapter = recyclerView.adapter as RestaurantsAdapter
        adapter.setData(restaurants)
    }
}

@BindingAdapter("adapter")
fun reviewsAdapterBinding(recyclerView: RecyclerView,
                              reviews: List<Review>) {
    if(recyclerView.adapter is RestaurantsReviewsAdapter) {
        val adapter = recyclerView.adapter as RestaurantsReviewsAdapter
        adapter.setData(reviews)
    }
}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String) {
    if(!TextUtils.isEmpty(url))
        ImageLoadingUtil().ImageLoadingWrapper(imageView.context,url,imageView, R.drawable.ic_launcher_background)
}