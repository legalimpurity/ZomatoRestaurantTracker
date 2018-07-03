package com.legalimpurity.zomatorestauranttracker.data.remote

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import io.reactivex.Single

interface ApiDataHelper {
    fun getRemoteGeocodeResponse(lat: Double, long: Double): Single<List<Restaurant?>>
//    fun getReviewsResponse(resId: String): Single<List<UserReviewsItem?>?>
}