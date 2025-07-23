package com.example.instaclone2.home.data

import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import java.util.UUID

interface HomeDataSource {

    fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>)

    fun fetchSession() : UserAuth {throw UnsupportedOperationException()}

    fun putFeed(response: List<Post>) {throw UnsupportedOperationException()}

}