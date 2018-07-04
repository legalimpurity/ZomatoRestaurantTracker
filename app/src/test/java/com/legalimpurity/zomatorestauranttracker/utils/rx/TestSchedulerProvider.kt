package com.legalimpurity.zomatorestauranttracker.utils.rx

import com.legalimpurity.zomatorestauranttracker.util.rx.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider(private val mTestScheduler: TestScheduler) : SchedulerProvider {

    override fun computation(): Scheduler {
        return mTestScheduler
    }

    override fun io(): Scheduler {
        return mTestScheduler
    }

    override fun ui(): Scheduler {
        return mTestScheduler
    }
}