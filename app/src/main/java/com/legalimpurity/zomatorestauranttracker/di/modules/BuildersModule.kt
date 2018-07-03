package com.legalimpurity.zomatorestauranttracker.di.modules

import com.legalimpurity.zomatorestauranttracker.ui.mainview.MainActivity
import com.legalimpurity.zomatorestauranttracker.ui.mainview.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindSplashActivity(): MainActivity
}