package com.fleenmobile.androidinterviewtask.main.fragment.list

import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.utils.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

/**
 * @author FleenMobile at 2018-02-25
 */
class ListFragmentPresenter(
        private val view: ListFragmentContract.View,
        private val router: ListFragmentContract.Router,
        private val repository: Repository,
        private val compositeDisposable: CompositeDisposable,
        private val userSelectedSubject: BehaviorSubject<User>,
        private val users: ArrayList<User>
) : ListFragmentContract.Presenter {

    override fun visible() {
        view.showSearchInfo()
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun userChosen(userId: Long) {
        val user = users.first { it.userId == userId }
        userSelectedSubject.onNext(user)

        router.navigateToDetailsFragment()
    }

    override fun searchButtonClicked(searchTerm: String) {
        compositeDisposable.add(
                repository
                        .getUsers(searchTerm)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext { cacheList(it) }
                        .subscribe(
                                { view.showUsers(it) },
                                { view.showSearchInfo() }
                        )
        )
    }

    private fun cacheList(users: List<User>) {
        this.users.clear()
        this.users.addAll(users)
    }
}