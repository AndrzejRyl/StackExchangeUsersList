package com.fleenmobile.androidinterviewtask.main.fragment.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.fleenmobile.androidinterviewtask.R

        /**
         * @author FleenMobile at 2018-02-26
         */

typealias OnClickListener = () -> Unit

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.user_item_reputation)
    lateinit var reputationTextView: TextView

    @BindView(R.id.user_item_name)
    lateinit var nameTextView: TextView

    var onClickListener: OnClickListener? = null

    init {
        ButterKnife.bind(this, itemView)
    }

    fun setData(name: String, reputation: String) {
        nameTextView.text = name
        reputationTextView.text = reputation
    }

    @OnClick(R.id.user_item_root_view)
    fun onUserClicked() {
        onClickListener?.invoke()
    }
}