package com.fleenmobile.androidinterviewtask.utils.resourceprovider

import android.support.annotation.StringRes

/**
 * @author FleenMobile at 2018-02-25
 */
interface ResourceProvider {

    fun getString(@StringRes id: Int): String

    fun getString(@StringRes id: Int, param: String): String
}