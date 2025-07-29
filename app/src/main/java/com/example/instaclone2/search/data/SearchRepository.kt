package com.example.instaclone2.search.data

import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import java.util.UUID

class SearchRepository (private val dataSource : SearchDataSource) {

    fun fetchUsers(name: String, callback: RequestCallback<List<UserAuth>>){
        dataSource.fetchUsers(name, object : RequestCallback<List<UserAuth>>{
            override fun onSucess(data: List<UserAuth>) {
                callback.onSucess(data)
            }

            override fun onFailure(message: String) {
                callback.onFailure(message)
            }

            override fun onComplete() {
                callback.onComplete()
            }
        })
    }

}