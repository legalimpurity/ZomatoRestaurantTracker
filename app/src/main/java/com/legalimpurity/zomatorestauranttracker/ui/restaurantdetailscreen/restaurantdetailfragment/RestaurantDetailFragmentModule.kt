package com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.di.factories.ViewModelProviderFactory
import com.legalimpurity.zomatorestauranttracker.ui.mainview.mainviewadapter.RestaurantsAdapter
import com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.RestaurantDetailModel
import com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.restaurantdetailfragment.restaurantdetailfragmentadapter.RestaurantsReviewsAdapter
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

    @Provides
    fun provideRestaurantsReviewsAdapterAdapter() = RestaurantsReviewsAdapter()

    @Provides
    fun provideRestaurantsReviewsRecyclerItemAnimator(): RecyclerView.ItemAnimator = DefaultItemAnimator()

    @Provides
    fun provideRestaurantsReviewsItemDecoration(ctx: Context): RecyclerView.ItemDecoration = DividerItemDecoration(ctx, DividerItemDecoration.VERTICAL)

}