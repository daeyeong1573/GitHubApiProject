package org.software.githubapiproject.repo

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import org.software.githubapiproject.request.api.GitHubApi
import javax.inject.Inject


class SearchUserRepo @Inject constructor(private val api : GitHubApi){
    suspend fun searchUser(user:String) = api.getSearchResponse(user)
    suspend fun getUserInfo(user : String) = api.getUserInfo(user)
}