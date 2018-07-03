package com.legalimpurity.zomatorestauranttracker.ui.mainview

import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.ui.baseui.BaseViewModel
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BaseViewModel<MainActivityNavigator>(dataManager,schedulerProvider, compositeDisposable) {

}