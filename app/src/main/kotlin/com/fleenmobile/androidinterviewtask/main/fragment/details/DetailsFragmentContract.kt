package com.fleenmobile.androidinterviewtask.main.fragment.details

import com.fleenmobile.androidinterviewtask.BaseContract
import com.fleenmobile.androidinterviewtask.data.User

/**
 * @author FleenMobile at 2018-02-25
 */
interface DetailsFragmentContract {

    interface View {
        fun showUser(user: User)
        fun showError(message: String)
    }

    interface Router

    interface Presenter : BaseContract.Presenter
}