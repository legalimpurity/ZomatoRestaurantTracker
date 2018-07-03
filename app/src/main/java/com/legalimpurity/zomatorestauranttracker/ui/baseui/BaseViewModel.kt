package com.legalimpurity.zomatorestauranttracker.ui.baseui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<N : BaseNavigator>(private val dataManager: DataManager, private val schedulerProvider: SchedulerProvider, private val compositeDisposable: CompositeDisposable) : ViewModel()
{
    private var mNavigator: N? = null
    val mIsLoading = ObservableBoolean(false)

    fun getCompositeDisposable() = compositeDisposable
    fun getSchedulerProvider() = schedulerProvider
    fun getDataManager() = dataManager

    fun getNavigator(): N? = mNavigator
    fun getIsLoading(): ObservableBoolean = mIsLoading

    fun setNavigator(navigator: N) {
        this.mNavigator = navigator
    }

    fun setIsLoading(isLoading: Boolean) = mIsLoading.set(isLoading)
}