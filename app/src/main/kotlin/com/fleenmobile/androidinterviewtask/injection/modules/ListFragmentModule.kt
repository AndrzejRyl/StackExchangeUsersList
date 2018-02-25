package com.fleenmobile.androidinterviewtask.injection.modules

import com.fleenmobile.androidinterviewtask.injection.RuntimeScope
import com.fleenmobile.androidinterviewtask.main.fragment.list.ListFragment
import com.fleenmobile.androidinterviewtask.main.fragment.list.ListFragmentContract
import com.fleenmobile.androidinterviewtask.main.fragment.list.ListFragmentPresenter
import dagger.Module
import dagger.Provides

/**
 * @author FleenMobile at 2018-02-25
 */
@Module
class ListFragmentModule {

    @Provides
    fun view(fragment: ListFragment): ListFragmentContract.View = fragment

    @Provides
    fun router(fragment: ListFragment): ListFragmentContract.Router = fragment

    @RuntimeScope
    @Provides
    fun presenter(
            view: ListFragmentContract.View,
            router: ListFragmentContract.Router
    ): ListFragmentContract.Presenter =
            ListFragmentPresenter(
                    view,
                    router
            )
}