package org.software.githubapiproject.data

data class SearchUserInfo(
    var incomplete_results: Boolean,
    var items: List<Item>,
    var total_count: Int
)