package com.legalimpurity.zomatorestauranttracker.ui.mainview.mainviewadapter

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant


class RestaurantItemViewModel(var imageUrl: String?, var title: String?)
{
    constructor(restaurant: Restaurant) : this(restaurant.thumb,restaurant.name)
}
