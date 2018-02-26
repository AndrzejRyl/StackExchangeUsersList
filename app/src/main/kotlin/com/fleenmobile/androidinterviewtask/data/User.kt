package com.fleenmobile.androidinterviewtask.data

/**
 * @author FleenMobile at 2018-02-25
 */

data class BadgeData(val bronze: Int = 0, val silver: Int = 0, val gold: Int = 0)

data class User(
        val badgeCounts: BadgeData = BadgeData(),
        val age: Int,
        val reputation: Int,
        val creationDate: Long,
        val userId: Long,
        val location: String,
        val profileImageUrl: String,
        val name: String
)