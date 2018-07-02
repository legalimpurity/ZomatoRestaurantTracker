package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class ReviewResponse(

	@field:SerializedName("reviews_start")
	val reviewsStart: Int? = null,

	@field:SerializedName("user_reviews")
	val userReviews: List<UserReviewsItem?>? = null,

	@field:SerializedName("Respond to reviews via Zomato Dashboard")
	val respondToReviewsViaZomatoDashboard: String? = null,

	@field:SerializedName("reviews_shown")
	val reviewsShown: Int? = null,

	@field:SerializedName("reviews_count")
	val reviewsCount: Int? = null
)