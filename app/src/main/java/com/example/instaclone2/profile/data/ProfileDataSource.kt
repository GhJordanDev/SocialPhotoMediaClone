package com.example.instaclone2.profile.data

import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import java.util.UUID

interface ProfileDataSource {

    fun fetchUserProfile(userUUID: String, callback: RequestCallback<Pair<UserAuth, Boolean?>>)

    fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>)

    fun followUser(userUUID: String, isFollow : Boolean, callback: RequestCallback<Boolean>){throw UnsupportedOperationException()}

    fun fetchSession() : UserAuth {throw UnsupportedOperationException()}

    fun putUser(response: Pair<UserAuth, Boolean?>) {throw UnsupportedOperationException()}

    fun putPosts(response: List<Post>?) {throw UnsupportedOperationException()}

}