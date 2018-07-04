package com.legalimpurity.zomatorestauranttracker.data

import com.legalimpurity.zomatorestauranttracker.data.local.db.DatabaseHelper
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Review
import com.legalimpurity.zomatorestauranttracker.data.remote.ApiDataHelper
import io.reactivex.Observable
import io.reactivex.Single

interface DataManager : ApiDataHelper, DatabaseHelper
{
    fun getRestaurantsDataRemoteAfterCachingGeocodeResponse(lat: Double, lon: Double): Single<List<Restaurant?>>
    fun getRestaurantsDataFromRemoteAndCache(lat: Double, lon: Double): Observable<List<Restaurant?>?>

    fun getRestaurantsReviewsDataFromRemoteAfterCachingResponses(resId: Long): Single<List<Review?>>
    fun getRestaurantsReviewsDataFromRemoteAndCache(resId: Long): Observable<List<Review?>>
}