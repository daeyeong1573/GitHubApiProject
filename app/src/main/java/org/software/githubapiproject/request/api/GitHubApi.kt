package org.software.githubapiproject.request.api

import org.software.githubapiproject.data.SearchUserInfo
import org.software.githubapiproject.data.UserInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {
    @GET("/search/users")
    suspend fun getSearchResponse(
        @Query("q") login: String?,
        @Query("page") page : Int = 1,
    ):Response<SearchUserInfo>

    @GET("/users/{userId}")
    suspend fun getUserInfo(
        @Path("userId") userId : String?
    ):Response<UserInfo>

}