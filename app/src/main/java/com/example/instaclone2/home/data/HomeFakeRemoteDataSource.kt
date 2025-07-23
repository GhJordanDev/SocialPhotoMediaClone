package com.example.instaclone2.home.data

import android.os.Handler
import android.os.Looper
import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Database
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import java.util.UUID

class HomeFakeRemoteDataSource : HomeDataSource {

    override fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>) {
        Handler(Looper.getMainLooper()).postDelayed({

            val posts = Database.feeds [userUUID]

            callback.onSucess(posts?.toList() ?: emptyList())

            callback.onComplete()
        }, 2000)
    }

}