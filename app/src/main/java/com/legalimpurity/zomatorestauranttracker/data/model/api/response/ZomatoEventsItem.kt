package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class ZomatoEventsItem(

	@field:SerializedName("event")
	val event: Event? = null
)