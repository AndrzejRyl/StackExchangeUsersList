package com.fleenmobile.androidinterviewtask.main.fragment.details

import com.fleenmobile.androidinterviewtask.R
import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.utils.resourceprovider.ResourceProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

/**
 * @author FleenMobile at 2018-02-25
 */
class DetailsFragmentPresenter(
        private val view: DetailsFragmentContract.View,
        private val router: DetailsFragmentContract.Router,
        private val userSelectedSubject: BehaviorSubject<User>,
        private val compositeDisposable: CompositeDisposable,
        private val resourceProvider: ResourceProvider
) : DetailsFragmentContract.Presenter {

    override fun visible() {
        compositeDisposable.add(
                userSelectedSubject
                        .subscribe(
                                { view.showUser(it) },
                                { view.showError(resourceProvider.getString(R.string.no_user)) }
                        )
        )
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}