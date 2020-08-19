package com.cermati.test.data.remote

import com.cermati.test.domain.entities.response.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API Backend Service
 */
interface RemoteAPI {
    /******************************* USER **************************/
    @GET("/search/users?per_page=10")
    fun login(@Query("q") string: String?, @Query("page") page: Int): Single<UserResponse?>?

}