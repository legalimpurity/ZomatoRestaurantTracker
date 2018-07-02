package com.legalimpurity.zomatorestauranttracker.data.remote

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.GeocodeApiResponse
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.ReviewAPIResponse
import io.reactivex.Single

interface ApiDataHelper
{
    fun getGeocodeResponse(lat: Double, long: Double): Single<GeocodeApiResponse>
    fun getReviewsResponse(resId: String): Single<ReviewAPIResponse>
}