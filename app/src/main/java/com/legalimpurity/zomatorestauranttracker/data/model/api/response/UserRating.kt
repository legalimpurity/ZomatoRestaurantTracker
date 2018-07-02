package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class UserRating(

	@field:SerializedName("aggregate_rating")
	val aggregateRating: String? = null,

	@field:SerializedName("rating_color")
	val ratingColor: String? = null,

	@field:SerializedName("rating_text")
	val ratingText: String? = null,

	@field:SerializedName("votes")
	val votes: String? = null
)