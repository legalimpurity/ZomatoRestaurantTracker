package com.legalimpurity.zomatorestauranttracker.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.data.DataManagerImpl
import com.legalimpurity.zomatorestauranttracker.data.local.db.AppDatabase
import com.legalimpurity.zomatorestauranttracker.data.local.db.DatabaseHelper
import com.legalimpurity.zomatorestauranttracker.data.local.db.DatabaseHelperImplementation
import com.legalimpurity.zomatorestauranttracker.data.remote.ApiDataHelper
import com.legalimpurity.zomatorestauranttracker.data.remote.ApiDataHelperImpl
import com.legalimpurity.zomatorestauranttracker.di.DatabaseInfo
import com.legalimpurity.zomatorestauranttracker.util.DB_NAME
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProviderImpl
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideDataManager(appDataManager: DataManagerImpl): DataManager = appDataManager

    @Singleton
    @Provides
    fun provideScheduleProvider(): SchedulerProvider = SchedulerProviderImpl()

    @Singleton
    @Provides
    fun provideApiDataHelper(retrofit: Retrofit): ApiDataHelper = ApiDataHelperImpl(retrofit)

    @Singleton
    @Provides
    fun provideContext(app: Application): Context = app.baseContext

    @Singleton
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, dbName).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: DatabaseHelperImplementation): DatabaseHelper = appDbHelper

    @DatabaseInfo
    @Provides
    fun provideDatabaseName(): String = DB_NAME
}