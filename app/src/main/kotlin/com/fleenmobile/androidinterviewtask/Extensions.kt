package com.fleenmobile.androidinterviewtask

import android.app.Activity
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast

/**
 * @author FleenMobile at 2018-02-26
 */
fun Activity.showToast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun View.hide() {
    visibility = GONE
}

fun View.show() {
    visibility = VISIBLE
}

fun FragmentManager.changeFragment(
        @IdRes containerViewId: Int,
        fragment: Fragment, tag: String) {

    val fragmentTransaction = beginTransaction()

    fragmentTransaction
            .replace(containerViewId, fragment, tag)
            .commit()
    executePendingTransactions()
}

fun Activity.replaceFragment(
        @IdRes containerViewId: Int,
        fragment: Fragment,
        tag: String
) = (this as AppCompatActivity).supportFragmentManager.changeFragment(containerViewId, fragment, tag)


fun FragmentManager.findFragmentByTag(tag: String, defaultValue: () -> Fragment) =
        findFragmentByTag(tag) ?: defaultValue.invoke()