package com.example.instaclone2.home.data

import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import java.util.UUID

class HomeRepository (private val dataSourceFactory: HomeDataSourceFactory) {

    fun fetchFeed(callback: RequestCallback<List<Post>>){
        val localDataSource = dataSourceFactory.createLocalDataSource()
        val userAuth = localDataSource.fetchSession()

        val dataSource = dataSourceFactory.createFromFeed()

        dataSource.fetchFeed(userAuth.uuid, object : RequestCallback<List<Post>>{
            override fun onSucess(data: List<Post>) {
                localDataSource.putFeed(data)
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