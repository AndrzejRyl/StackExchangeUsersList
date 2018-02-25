package com.fleenmobile.androidinterviewtask.injection.modules

import com.fleenmobile.androidinterviewtask.injection.RuntimeScope
import com.fleenmobile.androidinterviewtask.main.fragment.details.DetailsFragment
import com.fleenmobile.androidinterviewtask.main.fragment.details.DetailsFragmentContract
import com.fleenmobile.androidinterviewtask.main.fragment.details.DetailsFragmentPresenter
import dagger.Module
import dagger.Provides

/**
 * @author FleenMobile at 2018-02-25
 */
@Module
class DetailsFragmentModule {
    @Provides
    fun view(fragment: DetailsFragment): DetailsFragmentContract.View = fragment

    @Provides
    fun router(fragment: DetailsFragment): DetailsFragmentContract.Router = fragment

    @RuntimeScope
    @Provides
    fun presenter(
            view: DetailsFragmentContract.View,
            router: DetailsFragmentContract.Router
    ): DetailsFragmentContract.Presenter =
            DetailsFragmentPresenter(
                    view,
                    router
            )
}