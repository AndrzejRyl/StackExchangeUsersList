package com.fleenmobile.androidinterviewtask.injection.modules

import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.main.fragment.details.DetailsFragment
import com.fleenmobile.androidinterviewtask.main.fragment.details.DetailsFragmentContract
import com.fleenmobile.androidinterviewtask.main.fragment.details.DetailsFragmentPresenter
import com.fleenmobile.androidinterviewtask.utils.resourceprovider.ResourceProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

/**
 * @author FleenMobile at 2018-02-25
 */
@Module
class DetailsFragmentModule {
    @Provides
    fun view(fragment: DetailsFragment): DetailsFragmentContract.View = fragment

    @Provides
    fun router(fragment: DetailsFragment): DetailsFragmentContract.Router = fragment

    @Provides
    fun presenter(
            view: DetailsFragmentContract.View,
            router: DetailsFragmentContract.Router,
            userSelectedSubject: BehaviorSubject<User>,
            compositeDisposable: CompositeDisposable,
            resourceProvider: ResourceProvider
    ): DetailsFragmentContract.Presenter =
            DetailsFragmentPresenter(
                    view,
                    router,
                    userSelectedSubject,
                    compositeDisposable,
                    resourceProvider
            )
}