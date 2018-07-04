package com.legalimpurity.zomatorestauranttracker.data.remote

import com.legalimpurity.zomatorestauranttracker.data.model.api.response.NearbyRestaurantsItem
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Review
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.UserReviewsItem
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
    override fun getRemoteGeocodeResponse(lat: Double, long: Double): Single<List<Restaurant?>> = retrofitService!!.getGeocodeResponse(lat,long)
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

    override fun getReviewsResponse(resId: Long): Single<List<Review?>?> = retrofitService!!.getReviewsResponse(resId.toString())
            .map { reviewApiResponse ->
                reviewApiResponse.userReviews
            }
            .toObservable()
            .flatMap { listOfUserReviewItems ->
                Observable.fromIterable<UserReviewsItem>(listOfUserReviewItems)
            }
            .map { reviewItem ->
                reviewItem.review
            }
            .toList()
}