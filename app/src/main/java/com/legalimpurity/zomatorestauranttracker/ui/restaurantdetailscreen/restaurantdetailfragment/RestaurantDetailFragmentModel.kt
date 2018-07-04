package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.data.model.api.response.Review
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseViewModel
import com.legalimpurity.zomatorestauranttracker.util.AppLogger
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class RestaurantDetailFragmentModel(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BaseViewModel<RestaurantDetailFragmentNavigator>(dataManager,schedulerProvider, compositeDisposable) {

    var titleString = ObservableField<String>()
    var imageUrlString = ObservableField<String>()
    var restaurantId = ObservableField<Long>()

    val restaurantReviewsObservableArrayList = ObservableArrayList<Review?>()
    val restaurantReviewsLiveData: MutableLiveData<List<Review?>> = MutableLiveData()

    init {
        titleString.set("")
        imageUrlString.set("")
        restaurantId.set(0)
    }

    fun loadReviewsForRestaurant()
    {
        getCompositeDisposable().add(
                getDataManager().getRestaurantsReviewsDataFromRemoteAfterCachingResponses(restaurantId.get() ?: 0)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe({ reviewsList ->
                            restaurantReviewsLiveData.value = reviewsList
                        },
                                { throwable ->
                                    AppLogger.d(throwable.localizedMessage)
                                }
                        )
        )

    }
}