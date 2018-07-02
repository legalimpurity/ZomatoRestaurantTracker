package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class PhotosItem(

	@field:SerializedName("photo")
	val photo: Photo? = null
)