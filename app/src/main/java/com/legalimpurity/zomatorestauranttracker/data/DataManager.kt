package com.legalimpurity.zomatorestauranttracker.data

import com.legalimpurity.zomatorestauranttracker.data.local.db.DatabaseHelper
import com.legalimpurity.zomatorestauranttracker.data.remote.ApiDataHelper

interface DataManager : ApiDataHelper, DatabaseHelper
{

}