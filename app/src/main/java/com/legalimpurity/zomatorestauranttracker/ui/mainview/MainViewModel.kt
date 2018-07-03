package com.legalimpurity.zomatorestauranttracker.ui.mainview

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Restaurant
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseViewModel
import com.legalimpurity.zomatorestauranttracker.util.AppLogger
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BaseViewModel<MainActivityNavigator>(dataManager,schedulerProvider, compositeDisposable) {

    var latitudeString = ObservableField<String>()
    var longitudeString = ObservableField<String>()

    val restaurantItemsObservableArrayList = ObservableArrayList<Restaurant?>()
    val restaurantItemsLiveData: MutableLiveData<List<Restaurant?>> = MutableLiveData()

    init {
        latitudeString.set("77.325816")
        longitudeString.set("28.568139")
    }

    fun loadRestaurantsForCoordinates()
    {
        val latDouble = latitudeString.get()?.toDouble() ?: 0.0
        val lonDouble = longitudeString.get()?.toDouble() ?: 0.0
        getCompositeDisposable().add(
                getDataManager().getRemoteAfterCachingGeocodeResponse(latDouble,lonDouble)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe({restaurantsList ->
                            restaurantItemsLiveData.value = restaurantsList
                        },
                                { throwable ->
                                    AppLogger.d(throwable.localizedMessage)
                                }
                        )
        )
    }

}