package com.fleenmobile.androidinterviewtask.data

/**
 * @author FleenMobile at 2018-02-25
 */

data class BadgeData(val bronze: Int, val silver: Int, val gold: Int)

data class User(
        val badgeCounts: BadgeData,
        val age: Int,
        val reputation: Int,
        val creationDate: Long,
        val userId: Long,
        val location: String,
        val profileImageUrl: String,
        val name: String
)