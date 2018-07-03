package com.legalimpurity.zomatorestauranttracker.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.ui.mainview.mainviewadapter.RestaurantsAdapter
import java.util.ArrayList

@BindingAdapter("adapter")
fun restaurantsAdapterBinding(recyclerView: RecyclerView,
                                 restaurants: List<Restaurant>) {
    if(recyclerView.adapter is RestaurantsAdapter) {
        val adapter = recyclerView.adapter as RestaurantsAdapter
        adapter.setData(restaurants)
    }
}
