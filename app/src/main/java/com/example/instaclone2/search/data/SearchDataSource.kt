package com.example.instaclone2.search.data

import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.UserAuth

interface SearchDataSource {
    fun fetchUsers(name: String, callback: RequestCallback<List<UserAuth>>)


}