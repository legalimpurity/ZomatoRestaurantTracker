package com.legalimpurity.zomatorestauranttracker.data.remote

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.NearbyRestaurantsItem
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

class ApiDataHelperImpl @Inject constructor(retrofit: Retrofit): ApiDataHelper
{
    private var retrofitService: ZomatoApiService? = null
    init {
        retrofitService = retrofit.create(ZomatoApiService::class.java)
    }
    override fun getGeocodeResponse(lat: Double, long: Double): Single<List<Restaurant?>> = retrofitService!!.getGeocodeResponse(lat,long)
            .map { geocodeApiResponse ->
                geocodeApiResponse.nearbyRestaurants
            }
            .toObservable()
            .flatMap { listOfNearbyRestaurantItems ->
                Observable.fromIterable<NearbyRestaurantsItem>(listOfNearbyRestaurantItems)
            }
            .map { nearbyRestaurantsItem ->
                nearbyRestaurantsItem.restaurant
            }
            .toList()

//    override fun getReviewsResponse(resId: String): Single<List<UserReviewsItem?>?> = retrofitService!!.getReviewsResponse(resId)
//            .map {
//                it.userReviews
//            }
}