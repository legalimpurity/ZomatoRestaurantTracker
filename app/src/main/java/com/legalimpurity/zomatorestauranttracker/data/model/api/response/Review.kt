package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class Review(

	@field:SerializedName("rating_text")
	val ratingText: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("timestamp")
	val timestamp: Int? = null,

	@field:SerializedName("likes")
	val likes: Int? = null
)