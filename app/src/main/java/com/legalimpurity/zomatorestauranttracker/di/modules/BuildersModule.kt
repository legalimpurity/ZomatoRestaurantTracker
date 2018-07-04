package com.legalimpurity.zomatorestauranttracker.di.modules

import com.legalimpurity.zomatorestauranttracker.ui.mainview.MainActivity
import com.legalimpurity.zomatorestauranttracker.ui.mainview.MainActivityModule
import com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.RestaurantDetailActivity
import com.legalimpurity.zomatorestauranttracker.ui.restaurantdetailscreen.RestaurantDetailModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [RestaurantDetailModule::class])
    abstract fun bindRestaurantDetailActivity(): RestaurantDetailActivity
}