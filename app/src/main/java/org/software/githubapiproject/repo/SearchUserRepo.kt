package org.software.githubapiproject.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import org.software.githubapiproject.page.MyPagingSource
import org.software.githubapiproject.request.api.GitHubApi
import javax.inject.Inject


class SearchUserRepo @Inject constructor(private val api: GitHubApi) {
    fun searchUser(user: String) = Pager(
        config = PagingConfig(pageSize = 5, maxSize = 25, enablePlaceholders = false),
        pagingSourceFactory = { MyPagingSource(api, user) }).flow

    suspend fun getUserInfo(user: String) = api.getUserInfo(user)
}