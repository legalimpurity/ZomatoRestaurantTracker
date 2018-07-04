package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment

import android.databinding.ObservableField
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseViewModel
import com.legalimpurity.zomatorestauranttracker.util.AppLogger
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class RestaurantDetailFragmentModel(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BaseViewModel<RestaurantDetailFragmentNavigator>(dataManager,schedulerProvider, compositeDisposable) {

    var titleString = ObservableField<String>()
    var imageUrlString = ObservableField<String>()
    var restaurantId = ObservableField<Long>()

    init {
        titleString.set("")
        imageUrlString.set("")
        restaurantId.set(0)
    }

    fun loadReviewsForRestaurant()
    {
        getCompositeDisposable().add(
                getDataManager().getReviewsResponse(restaurantId.get().toString())
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe({ reviewsList ->
                            AppLogger.d(reviewsList.toString())
                        },
                                { throwable ->
                                    AppLogger.d(throwable.localizedMessage)
                                }
                        )
        )

    }
}