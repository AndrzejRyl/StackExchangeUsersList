package com.fleenmobile.androidinterviewtask.main.fragment.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fleenmobile.androidinterviewtask.R
import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.utils.resourceprovider.ResourceProvider

        /**
         * @author FleenMobile at 2018-02-26
         */

typealias OnUserChosenListener = (Long) -> Unit

class UsersAdapter(
        private val data: MutableList<User>,
        private val resourceProvider: ResourceProvider
) : RecyclerView.Adapter<UserViewHolder>() {

    var onUserChosenListener: OnUserChosenListener? = null

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        if (position >= data.size) return

        val user = data[position]

        holder.apply {
            setData(
                    user.name,
                    resourceProvider.getString(R.string.reputation, "${user.reputation}")
            )
            onClickListener = { onUserChosenListener?.invoke(user.userId) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_item_view, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    fun refreshData(users: List<User>) {
        data.clear()
        data.addAll(users)
        notifyDataSetChanged()
    }
}