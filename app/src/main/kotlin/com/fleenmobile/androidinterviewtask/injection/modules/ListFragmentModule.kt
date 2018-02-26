package com.fleenmobile.androidinterviewtask.injection.modules

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.main.fragment.list.ListFragment
import com.fleenmobile.androidinterviewtask.main.fragment.list.ListFragmentContract
import com.fleenmobile.androidinterviewtask.main.fragment.list.ListFragmentPresenter
import com.fleenmobile.androidinterviewtask.main.fragment.list.adapter.UsersAdapter
import com.fleenmobile.androidinterviewtask.utils.repository.Repository
import com.fleenmobile.androidinterviewtask.utils.resourceprovider.ResourceProvider
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

    @Provides
    fun layoutManager(context: Context): RecyclerView.LayoutManager = LinearLayoutManager(context)

    @Provides
    fun usersAdapter(resourceProvider: ResourceProvider) =
            UsersAdapter(mutableListOf(), resourceProvider)

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