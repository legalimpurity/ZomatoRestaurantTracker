package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("profile_deeplink")
	val profileDeeplink: String? = null,

	@field:SerializedName("profile_image")
	val profileImage: String? = null,

	@field:SerializedName("profile_url")
	val profileUrl: String? = null,

	@field:SerializedName("foodie_color")
	val foodieColor: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("foodie_level_num")
	val foodieLevelNum: Int? = null,

	@field:SerializedName("foodie_level")
	val foodieLevel: String? = null
)