package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class Popularity(

	@field:SerializedName("nightlife_index")
	val nightlifeIndex: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("top_cuisines")
	val topCuisines: List<String?>? = null,

	@field:SerializedName("popularity")
	val popularity: String? = null,

	@field:SerializedName("nearby_res")
	val nearbyRes: List<String?>? = null,

	@field:SerializedName("nightlife_res")
	val nightlifeRes: String? = null,

	@field:SerializedName("subzone_id")
	val subzoneId: Int? = null,

	@field:SerializedName("popularity_res")
	val popularityRes: String? = null,

	@field:SerializedName("subzone")
	val subzone: String? = null
)