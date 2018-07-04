package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen

import android.arch.lifecycle.ViewModelProvider
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.di.factories.ViewModelProviderFactory
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class RestaurantDetailModule
{
    @Provides
    fun provideRestaurantDetailModel(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) = RestaurantDetailModel(dataManager, schedulerProvider, compositeDisposable)

    @Provides
    fun provideRestaurantDetailModelFactory(restaurantDetailModel: RestaurantDetailModel) : ViewModelProvider.Factory = ViewModelProviderFactory<RestaurantDetailModel>(restaurantDetailModel)

//    @Provides
//    fun provideRestaurantsSectionsPagerAdapter() = RestaurantsAdapter()
//
//    @Provides
//    fun provideRestaurantsRecyclerLayoutManager(ctx: Context) : RecyclerView.LayoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL,false)
//
//    @Provides
//    fun provideRestaurantsRecyclerItemAnimator(): RecyclerView.ItemAnimator = DefaultItemAnimator()
//
//    @Provides
//    fun provideRestaurantsRecyclerItemDecoration(ctx: Context): RecyclerView.ItemDecoration = DividerItemDecoration(ctx, DividerItemDecoration.VERTICAL)

}