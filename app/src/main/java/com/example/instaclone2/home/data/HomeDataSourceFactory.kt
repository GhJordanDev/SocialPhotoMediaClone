package com.example.instaclone2.home.data

import com.example.instaclone2.common.base.Cache
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth

class HomeDataSourceFactory (private val feedCache : Cache <List<Post>>) {

    fun createLocalDataSource(): HomeDataSource{
        return HomeLocalDataSource(feedCache)
    }

    fun createFromFeed() : HomeDataSource{
        if(feedCache.isCached()){
            return HomeLocalDataSource(feedCache)
        }
        return HomeFakeRemoteDataSource()
    }
}