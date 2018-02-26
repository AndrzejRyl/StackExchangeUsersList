package com.fleenmobile.androidinterviewtask.main.fragment.details

import com.fleenmobile.androidinterviewtask.BaseFragment
import com.fleenmobile.androidinterviewtask.R
import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.showToast

/**
 * @author FleenMobile at 2018-02-25
 */
class DetailsFragment : BaseFragment<DetailsFragmentContract.Presenter>(),
        DetailsFragmentContract.View, DetailsFragmentContract.Router {

    override val layoutId: Int = R.layout.fragment_details

    override fun showUser(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(message: String) {
        activity.showToast(message)
    }
}