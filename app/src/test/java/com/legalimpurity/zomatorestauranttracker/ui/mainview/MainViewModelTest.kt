package com.legalimpurity.zomatorestauranttracker.ui.mainview

import com.legalimpurity.zomatorestauranttracker.data.DataManager
import com.legalimpurity.zomatorestauranttracker.utils.rx.TestSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest
{
    @Mock
    lateinit var mMainActivityCallback: MainActivityNavigator

    @Mock
    lateinit var mMockDataManager: DataManager

    private val compositeDisposable = CompositeDisposable()
    private var mMainViewModel: MainViewModel? = null
    private val mTestScheduler: TestScheduler = TestScheduler()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)
        mMainViewModel = MainViewModel(mMockDataManager, testSchedulerProvider,compositeDisposable)
        mMainViewModel?.setNavigator(mMainActivityCallback)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        compositeDisposable.dispose()
    }

}