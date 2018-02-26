package com.fleenmobile.androidinterviewtask.utils.repository

import com.fleenmobile.androidinterviewtask.api.ApiService
import com.fleenmobile.androidinterviewtask.data.User
import io.reactivex.Observable

/**
 * @author FleenMobile at 2018-02-25
 */
class RepositoryImpl(private val apiService: ApiService) : Repository {

    override fun getUsers(searchTerm: String): Observable<List<User>> =
            apiService
                    .getUsers(searchTerm)
                    .map { it.users }
}