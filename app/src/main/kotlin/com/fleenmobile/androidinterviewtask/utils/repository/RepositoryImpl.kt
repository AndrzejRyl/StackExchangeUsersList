package com.fleenmobile.androidinterviewtask.utils.repository

import com.fleenmobile.androidinterviewtask.data.BadgeData
import com.fleenmobile.androidinterviewtask.data.User
import io.reactivex.Observable
import java.util.*

/**
 * @author FleenMobile at 2018-02-25
 */
class RepositoryImpl : Repository {

    override fun getUsers(searchTerm: String): Observable<List<User>> {
        val users = arrayListOf<User>(
                User(
                        BadgeData(10),
                        32,
                        124,
                        Date().time,
                        14,
                        "location location location",
                        "https://www.gravatar.com/avatar/880c18bcc1ffc2f886e71dd14f3ffbf1?s=128&d=identicon&r=PG",
                        "Kevin1"
                ),
                User(
                        BadgeData(10,1,2),
                        32,
                        124423,
                        Date().time,
                        143,
                        "location location location",
                        "https://www.gravatar.com/avatar/880c18bcc1ffc2f886e71dd14f3ffbf1?s=128&d=identicon&r=PG",
                        "Kevin2"
                ),
                User(
                        BadgeData(10,11,22),
                        32,
                        1,
                        Date().time,
                        147,
                        "loca4342",
                        "https://www.gravatar.com/avatar/880c18bcc1ffc2f886e71dd14f3ffbf1?s=128&d=identicon&r=PG",
                        "Kevin3"
                )
        )

        // todo use retrofit to retrieve it

        return Observable.fromArray(users)
    }
}