package com.fleenmobile.androidinterviewtask.main

import com.fleenmobile.androidinterviewtask.BaseContract

/**
 * @author FleenMobile at 2018-02-25
 */
interface MainActivityContract {

    interface View

    interface Router {
        fun navigateToListFragment()
        fun navigateToDetailsFragment()
    }

    interface Presenter : BaseContract.Presenter
}