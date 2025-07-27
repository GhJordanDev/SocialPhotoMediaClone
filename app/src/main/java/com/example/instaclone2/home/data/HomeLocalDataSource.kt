package com.example.instaclone2.home.data

import com.example.instaclone2.common.base.Cache
import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Database
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth

class HomeLocalDataSource( private val feedCache : Cache<List<Post>>) : HomeDataSource {

    override fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>) {
        val posts = feedCache.get(userUUID)
        if(posts != null){
            callback.onSucess(posts)
        }else{
            callback.onFailure("posts não existem")
        }
        callback.onComplete()
    }

    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?: throw RuntimeException ("usuário não logado")   }

    override fun putFeed(response: List<Post>?) {
        feedCache.put(response)
    }

}