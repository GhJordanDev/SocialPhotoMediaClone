package com.example.instaclone2.profile.data

import com.example.instaclone2.common.base.Cache
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth

class ProfileDataSourceFactory(
    private val profileCache : Cache<UserAuth>,
    private val postsCache : Cache<List<Post>>
) {

    fun createLocalDataSource(): ProfileDataSource{
        return ProfileLocalDataSource(profileCache, postsCache)
    }

    fun createFromUser() : ProfileDataSource{
        if(profileCache.isCached()){
            return ProfileLocalDataSource(profileCache, postsCache)
        }
        return ProfileFakeRemoteDataSource()
    }

    fun createFromPosts() : ProfileDataSource{
        if(postsCache.isCached()){
            return ProfileLocalDataSource(profileCache, postsCache)
        }
        return ProfileFakeRemoteDataSource()
    }
}