package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment.restaurantdetailfragmentadapter

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Review

class RestaurantsReviewItemViewModel(var reviewerName: String?, var reviewrImageUrl: String?, var reviewtext: String?)
{
    constructor(review: Review) : this(review.user?.name,review.user?.profileImage,review.ratingText)
}