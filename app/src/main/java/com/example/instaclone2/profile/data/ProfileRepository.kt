package com.example.instaclone2.profile.data

import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth

class ProfileRepository (private val dataSource: ProfileDataSource) {

    fun fetchUserProfile(userAuth: String, callback: RequestCallback<UserAuth>){
        dataSource.fetchUserProfile(userAuth, callback)
    }

    fun fetchUserPosts(userAuth: String, callback: RequestCallback<List<Post>>){
        dataSource.fetchUserPosts(userAuth, callback)
    }

}