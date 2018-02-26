package com.fleenmobile.androidinterviewtask.utils.resourceprovider

import android.content.Context

/**
 * @author FleenMobile at 2018-02-27
 */
class ResourceProviderImpl(private val context: Context) : ResourceProvider {

    override fun getString(id: Int): String = context.getString(id)

    override fun getString(id: Int, param: String) = context.getString(id, param)
}