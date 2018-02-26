package com.fleenmobile.androidinterviewtask.main.fragment.details

import android.widget.TextView
import butterknife.BindView
import com.fleenmobile.androidinterviewtask.BaseFragment
import com.fleenmobile.androidinterviewtask.R
import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.showToast

/**
 * @author FleenMobile at 2018-02-25
 */
class DetailsFragment : BaseFragment<DetailsFragmentContract.Presenter>(),
        DetailsFragmentContract.View, DetailsFragmentContract.Router {

    @BindView(R.id.details_fragment_username)
    lateinit var usernameTextView: TextView

    override val layoutId: Int = R.layout.fragment_details

    override fun showUser(user: User) {
        usernameTextView.text = user.name
        //todo add rest
    }

    override fun showError(message: String) {
        activity.showToast(message)
    }
}