package com.fleenmobile.androidinterviewtask.utils.resourceprovider

import android.app.Activity
import android.support.annotation.StringRes

/**
 * @author FleenMobile at 2018-02-25
 */
class ResourceProvider(private val activity: Activity) {

    fun getString(@StringRes id: Int) = activity.getString(id)
}