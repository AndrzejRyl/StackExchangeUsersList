package com.fleenmobile.androidinterviewtask.main.fragment.list

import android.support.v4.app.Fragment
import com.fleenmobile.androidinterviewtask.data.User

/**
 * @author FleenMobile at 2018-02-25
 */
class ListFragment : Fragment(), ListFragmentContract.View, ListFragmentContract.Router {

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