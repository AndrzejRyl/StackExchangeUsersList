package com.fleenmobile.androidinterviewtask.main.fragment.list

import android.support.v7.widget.RecyclerView
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.fleenmobile.androidinterviewtask.BaseFragment
import com.fleenmobile.androidinterviewtask.R
import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.hide
import com.fleenmobile.androidinterviewtask.main.MainActivity
import com.fleenmobile.androidinterviewtask.main.fragment.list.adapter.UsersAdapter
import com.fleenmobile.androidinterviewtask.show
import javax.inject.Inject

/**
 * @author FleenMobile at 2018-02-25
 */
class ListFragment : BaseFragment<ListFragmentContract.Presenter>(),
        ListFragmentContract.View, ListFragmentContract.Router {

    @BindView(R.id.list_fragment_users_list)
    lateinit var usersRecyclerView: RecyclerView

    @BindView(R.id.list_fragment_search_info)
    lateinit var infoTextView: TextView

    @BindView(R.id.list_fragment_search)
    lateinit var searchEditText: EditText

    @Inject
    lateinit var usersAdapter: UsersAdapter

    @Inject
    lateinit var layoutManager: RecyclerView.LayoutManager

    override val layoutId: Int = R.layout.fragment_list

    override fun initialize() {
        super.initialize()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        usersRecyclerView.layoutManager = layoutManager
        usersAdapter.onUserChosenListener = { presenter.userChosen(it) }
        usersRecyclerView.adapter = usersAdapter
    }

    override fun showUsers(users: List<User>) {
        infoTextView.hide()
        usersRecyclerView.show()
        usersAdapter.refreshData(users)
    }

    override fun showSearchInfo() {
        usersRecyclerView.hide()
        infoTextView.show()
    }

    override fun navigateToDetailsFragment() {
        (activity as MainActivity).navigateToDetailsFragment()
    }

    @OnClick(R.id.list_fragment_search_button)
    fun onSearchClicked() {
        presenter.searchButtonClicked(searchEditText.text.toString())
    }
}