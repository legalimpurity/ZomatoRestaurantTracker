package com.legalimpurity.zomatorestauranttracker.di

import android.app.Application
import com.legalimpurity.zomatorestauranttracker.ZomatoApp
import com.legalimpurity.zomatorestauranttracker.di.modules.AppModule
import com.legalimpurity.zomatorestauranttracker.di.modules.BuildersModule
import com.legalimpurity.zomatorestauranttracker.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, BuildersModule::class, AndroidSupportInjectionModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application: Application) : Builder
        fun build() : AppComponent
    }

    fun inject(app: ZomatoApp)
}