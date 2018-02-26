package com.fleenmobile.androidinterviewtask.data

import com.google.gson.annotations.SerializedName

/**
 * @author FleenMobile at 2018-02-26
 */
data class UsersResponse(@SerializedName("items") val users: List<User>)