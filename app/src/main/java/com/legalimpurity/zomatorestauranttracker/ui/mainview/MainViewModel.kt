package com.legalimpurity.zomatorestauranttracker.ui.mainview

import android.databinding.ObservableField
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseViewModel
import com.legalimpurity.zomatorestauranttracker.util.AppLogger
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BaseViewModel<MainActivityNavigator>(dataManager,schedulerProvider, compositeDisposable) {

    var latitudeString = ObservableField<String>()
    var longitudeString = ObservableField<String>()

    init {
        latitudeString.set("77.325816")
        longitudeString.set("28.568139")
    }

    fun loadRestaurantsForCoordinates()
    {
        val latDouble = latitudeString.get()?.toDouble() ?: 0.0
        val lonDouble = longitudeString.get()?.toDouble() ?: 0.0
        getCompositeDisposable().add(
                getDataManager().getRemoteGeocodeResponse(latDouble,lonDouble)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe({restaurantsList ->
                            AppLogger.d(restaurantsList.toString())
                        },
                                { throwable ->
                                    AppLogger.d(throwable.localizedMessage)
                                }
                        )
        )
    }
}