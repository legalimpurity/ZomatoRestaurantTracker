package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class GeocodeApiResponse(
	@field:SerializedName("nearby_restaurants")
	val nearbyRestaurants: List<NearbyRestaurantsItem?>? = null
	)