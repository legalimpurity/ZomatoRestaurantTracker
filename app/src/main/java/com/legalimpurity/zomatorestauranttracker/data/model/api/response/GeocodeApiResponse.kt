package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class GeocodeApiResponse(

	@field:SerializedName("popularity")
	val popularity: Popularity? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("nearby_restaurants")
	val nearbyRestaurants: List<NearbyRestaurantsItem?>? = null,

	@field:SerializedName("location")
	val location: Location? = null
)