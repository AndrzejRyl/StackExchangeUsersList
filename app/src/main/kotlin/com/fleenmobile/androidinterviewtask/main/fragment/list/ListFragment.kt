package com.fleenmobile.androidinterviewtask.main.fragment.list

import com.fleenmobile.androidinterviewtask.BaseFragment
import com.fleenmobile.androidinterviewtask.R
import com.fleenmobile.androidinterviewtask.data.User

/**
 * @author FleenMobile at 2018-02-25
 */
class ListFragment : BaseFragment<ListFragmentContract.Presenter>(),
        ListFragmentContract.View, ListFragmentContract.Router {

    override val layoutId: Int = R.layout.fragment_list

    override fun showUsers(users: List<User>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSearchInfo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToDetailsFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}