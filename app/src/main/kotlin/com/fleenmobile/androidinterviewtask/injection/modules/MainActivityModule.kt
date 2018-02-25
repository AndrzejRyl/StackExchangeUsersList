package com.fleenmobile.androidinterviewtask.injection.modules

import com.fleenmobile.androidinterviewtask.injection.RuntimeScope
import com.fleenmobile.androidinterviewtask.main.MainActivity
import com.fleenmobile.androidinterviewtask.main.MainActivityContract
import com.fleenmobile.androidinterviewtask.main.MainActivityPresenter
import dagger.Module
import dagger.Provides

/**
 * @author FleenMobile at 2018-02-25
 */
@Module
class MainActivityModule {

    @Provides
    fun view(activity: MainActivity): MainActivityContract.View = activity

    @Provides
    fun router(activity: MainActivity): MainActivityContract.Router = activity

    @RuntimeScope
    @Provides
    fun presenter(
            view: MainActivityContract.View,
            router: MainActivityContract.Router
    ): MainActivityContract.Presenter =
            MainActivityPresenter(
                    view,
                    router
            )
}