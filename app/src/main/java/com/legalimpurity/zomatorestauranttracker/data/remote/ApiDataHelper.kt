package com.legalimpurity.zomatorestauranttracker.data.remote

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Review
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.UserReviewsItem
import io.reactivex.Single

interface ApiDataHelper {
    fun getRemoteGeocodeResponse(lat: Double, lon: Double): Single<List<Restaurant?>>
    fun getReviewsResponse(resId: Long): Single<List<Review?>?>
}