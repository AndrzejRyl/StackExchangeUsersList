package com.fleenmobile.androidinterviewtask.main

/**
 * @author FleenMobile at 2018-02-25
 */
class MainActivityPresenter(
        private val view: MainActivityContract.View,
        private val router: MainActivityContract.Router
) : MainActivityContract.Presenter {

    override fun visible() {
        router.navigateToListFragment()
    }

    override fun clear() {}
}