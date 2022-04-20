package org.software.githubapiproject.page

import android.content.ContentValues.TAG
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.software.githubapiproject.data.Item
import org.software.githubapiproject.data.SearchUserInfo
import org.software.githubapiproject.request.api.GitHubApi
import java.lang.Exception

private const val STARTING_PAGE_INDEX = 1


class MyPagingSource(
    private val gitHubApi: GitHubApi,
    private val loginId : String
): PagingSource<Int, Item>() {
        //데이터 로드
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        // LoadParams : 로드할 키와 항목 수 , LoadResult : 로드 작업의 결과
        return try {
            //키 값이 없을 경우 기본값을 사용함
            val position = params.key ?: STARTING_PAGE_INDEX
            val response = gitHubApi.getSearchResponse(loginId,position)
            val post = response?.body()!!.items

            LoadResult.Page(
                data = post!!,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position -1,
                nextKey = if (position < response.body()!!.total_count) position + 1 else null            )
        }catch (e : Exception){
         LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
      return 0
    }
}