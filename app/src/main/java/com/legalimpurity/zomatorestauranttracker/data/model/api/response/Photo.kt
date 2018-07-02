package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class Photo(

	@field:SerializedName("thumb_url")
	val thumbUrl: String? = null,

	@field:SerializedName("photo_id")
	val photoId: Int? = null,

	@field:SerializedName("md5sum")
	val md5sum: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("uuid")
	val uuid: Long? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("order")
	val order: Int? = null
)