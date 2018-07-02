package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class Location(

	@field:SerializedName("city_name")
	val cityName: String? = null,

	@field:SerializedName("entity_type")
	val entityType: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("country_name")
	val countryName: String? = null,

	@field:SerializedName("entity_id")
	val entityId: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("country_id")
	val countryId: Int? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null,

	@field:SerializedName("city_id")
	val cityId: Int? = null,

	@field:SerializedName("zipcode")
	val zipcode: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("locality_verbose")
	val localityVerbose: String? = null,

	@field:SerializedName("locality")
	val locality: String? = null
)