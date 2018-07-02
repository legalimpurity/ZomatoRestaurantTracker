package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import com.google.gson.annotations.SerializedName

data class Event(

	@field:SerializedName("end_date")
	val endDate: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("photos")
	val photos: List<PhotosItem?>? = null,

	@field:SerializedName("event_category_name")
	val eventCategoryName: String? = null,

	@field:SerializedName("friendly_end_date")
	val friendlyEndDate: String? = null,

	@field:SerializedName("friendly_timing_str")
	val friendlyTimingStr: String? = null,

	@field:SerializedName("disclaimer")
	val disclaimer: String? = null,

	@field:SerializedName("start_date")
	val startDate: String? = null,

	@field:SerializedName("show_share_url")
	val showShareUrl: Int? = null,

	@field:SerializedName("is_active")
	val isActive: Int? = null,

	@field:SerializedName("end_time")
	val endTime: String? = null,

	@field:SerializedName("is_end_time_set")
	val isEndTimeSet: Int? = null,

	@field:SerializedName("event_category")
	val eventCategory: Int? = null,

	@field:SerializedName("share_data")
	val shareData: ShareData? = null,

	@field:SerializedName("display_time")
	val displayTime: String? = null,

	@field:SerializedName("start_time")
	val startTime: String? = null,

	@field:SerializedName("date_added")
	val dateAdded: String? = null,

	@field:SerializedName("friendly_start_date")
	val friendlyStartDate: String? = null,

	@field:SerializedName("event_id")
	val eventId: Int? = null,

	@field:SerializedName("display_date")
	val displayDate: String? = null,

	@field:SerializedName("share_url")
	val shareUrl: String? = null,

	@field:SerializedName("is_valid")
	val isValid: Int? = null,

	@field:SerializedName("restaurants")
	val restaurants: List<Any?>? = null,

	@field:SerializedName("book_link")
	val bookLink: String? = null
)