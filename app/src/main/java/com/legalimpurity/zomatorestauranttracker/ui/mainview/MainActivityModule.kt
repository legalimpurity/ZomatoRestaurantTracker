package com.legalimpurity.zomatorestauranttracker.ui.mainview

import android.arch.lifecycle.ViewModelProvider
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.di.factories.ViewModelProviderFactory
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

}