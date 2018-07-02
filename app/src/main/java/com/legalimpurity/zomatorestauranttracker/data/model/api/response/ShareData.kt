package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class ShareData(

	@field:SerializedName("should_show")
	val shouldShow: Int? = null
)