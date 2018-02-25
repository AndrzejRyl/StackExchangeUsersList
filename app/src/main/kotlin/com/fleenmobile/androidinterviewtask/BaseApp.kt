package com.fleenmobile.androidinterviewtask

import android.app.Activity
import android.app.Application
import com.fleenmobile.androidinterviewtask.injection.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author FleenMobile at 2018-02-25
 */
class BaseApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> =
            activityInjector

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() =
            DaggerAppComponent.builder()
                    .application(this)
                    .build()
                    .inject(this)
}