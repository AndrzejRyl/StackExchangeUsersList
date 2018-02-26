package com.fleenmobile.androidinterviewtask.utils.resourceprovider

import android.content.Context
import android.support.annotation.StringRes

/**
 * @author FleenMobile at 2018-02-25
 */
class ResourceProvider(private val context: Context) {

    fun getString(@StringRes id: Int): String = context.getString(id)

    fun getString(@StringRes id: Int, param: String) = context.getString(id, param)
}