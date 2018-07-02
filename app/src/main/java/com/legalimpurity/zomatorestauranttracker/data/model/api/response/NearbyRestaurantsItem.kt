package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class NearbyRestaurantsItem(
	@field:SerializedName("restaurant")
	val restaurant: Restaurant? = null
)