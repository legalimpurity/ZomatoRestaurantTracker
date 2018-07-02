package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class ReviewAPIResponse(


	@field:SerializedName("user_reviews")
	val userReviews: List<UserReviewsItem?>? = null
)