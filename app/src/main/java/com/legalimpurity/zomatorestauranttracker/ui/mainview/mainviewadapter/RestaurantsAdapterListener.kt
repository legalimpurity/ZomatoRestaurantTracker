package com.legalimpurity.zomatorestauranttracker.ui.mainview.mainviewadapter

import android.content.Context
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant

interface RestaurantsAdapterListener
{
    fun onClick(restaurantItemPos: Int, context : Context)
}