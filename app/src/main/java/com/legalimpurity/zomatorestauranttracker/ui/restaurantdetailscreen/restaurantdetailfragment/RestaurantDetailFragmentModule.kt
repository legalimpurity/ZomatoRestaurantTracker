package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment

import android.arch.lifecycle.ViewModelProvider
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.di.factories.ViewModelProviderFactory
import com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.RestaurantDetailModel
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class RestaurantDetailFragmentModule {
    @Provides
    fun provideRestaurantDetailFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) = RestaurantDetailFragmentModel(dataManager, schedulerProvider, compositeDisposable)

    @Provides
    fun provideRestaurantDetailFragmentViewModelFactory(restaurantDetailFragmentModel: RestaurantDetailFragmentModel): ViewModelProvider.Factory = ViewModelProviderFactory<RestaurantDetailFragmentModel>(restaurantDetailFragmentModel)
}