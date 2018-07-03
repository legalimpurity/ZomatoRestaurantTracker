package com.legalimpurity.zomatorestauranttracker.data

import com.legalimpurity.zomatorestauranttracker.data.local.db.DatabaseHelper
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.data.remote.ApiDataHelper
import io.reactivex.Single

interface DataManager : ApiDataHelper, DatabaseHelper
{
    fun getRemoteAfterCachingGeocodeResponse(lat: Double, lon: Double): Single<List<Restaurant?>>

}