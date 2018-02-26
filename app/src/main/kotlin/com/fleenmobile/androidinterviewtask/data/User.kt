package com.fleenmobile.androidinterviewtask.data

import com.google.gson.annotations.SerializedName

/**
 * @author FleenMobile at 2018-02-25
 */

data class BadgeData(val bronze: Int = 0, val silver: Int = 0, val gold: Int = 0)

data class User(
        @SerializedName("badge_counts") val badgeCounts: BadgeData = BadgeData(),
        val age: Int,
        val reputation: Int,
        @SerializedName("creation_date") val creationDate: Long,
        @SerializedName("user_id") val userId: Long,
        val location: String,
        @SerializedName("profile_image") val profileImageUrl: String,
        @SerializedName("display_name") val name: String
)