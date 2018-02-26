package com.fleenmobile.androidinterviewtask.api

import com.fleenmobile.androidinterviewtask.data.UsersResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author FleenMobile at 2018-02-26
 */
interface ApiService {

    @GET("users")
    fun getUsers(
            @Query("inname") searchTerm: String,
            @Query("pagesize") pageSize: Int = 20,
            @Query("order") order: String = "asc",
            @Query("sort") sortBy: String = "name",
            @Query("site") site: String = "stackoverflow"): Observable<UsersResponse>
}