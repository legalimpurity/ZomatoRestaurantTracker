package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen

import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseViewModel
import com.legalimpurity.zomatorestauranttracker.ui.mainview.MainActivityNavigator
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class RestaurantDetailModel(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BaseViewModel<RestaurantDetailNavigator>(dataManager,schedulerProvider, compositeDisposable) {
}