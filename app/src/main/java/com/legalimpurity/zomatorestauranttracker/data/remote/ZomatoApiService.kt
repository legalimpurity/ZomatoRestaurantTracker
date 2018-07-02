package com.legalimpurity.zomatorestauranttracker.data.remote

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.GeocodeApiResponse
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.ReviewAPIResponse
import io.reactivex.Single
import retrofit2.http.*

interface ZomatoApiService {

    @GET("api/v2.1/geocode")
    fun getGeocodeResponse(@Query(value = "lat", encoded = true)lat: Double, @Query(value = "lon", encoded = true)lon: Double): Single<GeocodeApiResponse>

    @GET("api/v2.1/reviews")
    fun getReviewsResponse(@Query(value = "res_id", encoded = true)resId: String): Single<ReviewAPIResponse>
}