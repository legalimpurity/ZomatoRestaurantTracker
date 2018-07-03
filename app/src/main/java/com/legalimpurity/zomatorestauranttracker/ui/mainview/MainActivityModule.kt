package com.legalimpurity.zomatorestauranttracker.ui.mainview

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.di.factories.ViewModelProviderFactory
import com.legalimpurity.zomatorestauranttracker.ui.mainview.mainviewadapter.RestaurantsAdapter
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MainActivityModule
{
    @Provides
    fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) = MainViewModel(dataManager, schedulerProvider, compositeDisposable)

    @Provides
    fun provideMainViewModelFactory(mainViewModel: MainViewModel) : ViewModelProvider.Factory = ViewModelProviderFactory<MainViewModel>(mainViewModel)

    @Provides
    fun provideRestaurantsAdapter() = RestaurantsAdapter()

    @Provides
    fun provideRestaurantsRecyclerLayoutManager(ctx: Context) : RecyclerView.LayoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL,false)

    @Provides
    fun provideRestaurantsRecyclerItemAnimator(): RecyclerView.ItemAnimator = DefaultItemAnimator()

    @Provides
    fun provideRestaurantsRecyclerItemDecoration(ctx: Context): RecyclerView.ItemDecoration = DividerItemDecoration(ctx, DividerItemDecoration.VERTICAL)

}