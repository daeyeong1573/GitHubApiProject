package org.software.githubapiproject.request.api

import org.software.githubapiproject.data.UserInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("/search/users")
    suspend fun getUser(
        @Query("q") login: String?,
        @Query("page") page : Int = 1,
    ):Response<UserInfo>
}