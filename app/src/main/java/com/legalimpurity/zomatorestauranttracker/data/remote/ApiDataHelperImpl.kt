package com.legalimpurity.zomatorestauranttracker.data.remote

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.GeocodeApiResponse
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.ReviewAPIResponse
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

class ApiDataHelperImpl @Inject constructor(retrofit: Retrofit): ApiDataHelper
{
    private var retrofitService: ZomatoApiService? = null
    init {
        retrofitService = retrofit.create(ZomatoApiService::class.java)
    }
    override fun getGeocodeResponse(lat: Double, long: Double): Single<GeocodeApiResponse> = retrofitService!!.getGeocodeResponse(lat,long)
    override fun getReviewsResponse(resId: String): Single<ReviewAPIResponse> = retrofitService!!.getReviewsResponse(resId)
}