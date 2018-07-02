package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class UserReviewsItem(

	@field:SerializedName("review")
	val review: Review? = null
)