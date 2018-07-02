package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class Review(

	@field:SerializedName("rating_color")
	val ratingColor: String? = null,

	@field:SerializedName("review_time_friendly")
	val reviewTimeFriendly: String? = null,

	@field:SerializedName("rating_text")
	val ratingText: String? = null,

	@field:SerializedName("comments_count")
	val commentsCount: Int? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("review_text")
	val reviewText: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("timestamp")
	val timestamp: Int? = null,

	@field:SerializedName("likes")
	val likes: Int? = null
)