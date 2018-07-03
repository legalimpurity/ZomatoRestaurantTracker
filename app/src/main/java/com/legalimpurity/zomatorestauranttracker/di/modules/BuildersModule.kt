package com.legalimpurity.zomatorestauranttracker.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindSplashActivity(): MainActivity
}