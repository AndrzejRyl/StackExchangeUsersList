package com.fleenmobile.androidinterviewtask.injection.modules

import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.injection.RuntimeScope
import com.fleenmobile.androidinterviewtask.main.fragment.list.ListFragment
import com.fleenmobile.androidinterviewtask.main.fragment.list.ListFragmentContract
import com.fleenmobile.androidinterviewtask.main.fragment.list.ListFragmentPresenter
import com.fleenmobile.androidinterviewtask.utils.repository.Repository
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

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
            router: ListFragmentContract.Router,
            repository: Repository,
            compositeDisposable: CompositeDisposable,
            userSelectedSubject: BehaviorSubject<User>
    ): ListFragmentContract.Presenter =
            ListFragmentPresenter(
                    view,
                    router,
                    repository,
                    compositeDisposable,
                    userSelectedSubject,
                    arrayListOf()
            )
}