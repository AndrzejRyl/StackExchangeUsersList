package com.fleenmobile.androidinterviewtask.main.fragment.list

import com.fleenmobile.androidinterviewtask.BaseContract
import com.fleenmobile.androidinterviewtask.data.User

/**
 * @author FleenMobile at 2018-02-25
 */
interface ListFragmentContract {

    interface View {
        fun showUsers(users: List<User>)
        fun showSearchInfo()
    }

    interface Router {
        fun navigateToDetailsFragment()
    }

    interface Presenter : BaseContract.Presenter {
        fun userChosen(userId: Int)
        fun searchTermEntered(search: String)
    }
}