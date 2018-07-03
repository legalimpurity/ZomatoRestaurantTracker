package com.legalimpurity.zomatorestauranttracker.util.internetstateprovider

import android.content.Context
import android.net.ConnectivityManager

class InternetStateProviderImplementation(val context: Context) : InternetStateProvider {
    override fun isOnline(): Boolean {
        var returner = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        returner = activeNetwork != null && activeNetwork.isConnected
        return returner
    }
}