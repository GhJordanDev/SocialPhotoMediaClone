package com.example.instaclone2.profile.data

import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import java.util.UUID

class ProfileRepository (private val dataSourceFactory: ProfileDataSourceFactory) {

    fun clearCache(){
        val localDataSource = dataSourceFactory.createLocalDataSource()
        localDataSource.putPosts(null)
    }

    fun fetchUserProfile(uuid: String?, callback: RequestCallback <Pair<UserAuth, Boolean?>>){
        val localDataSource = dataSourceFactory.createLocalDataSource()
        val userId = uuid ?: localDataSource.fetchSession().uuid

        val dataSource = dataSourceFactory.createFromUser(uuid)

        dataSource.fetchUserProfile(userId, object : RequestCallback<Pair<UserAuth, Boolean?>>{
            override fun onSucess(data: Pair<UserAuth, Boolean?>) {
                if(uuid == null){
                    localDataSource.putUser(data)
                }
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

    fun fetchUserPosts(uuid: String?, callback: RequestCallback<List<Post>>){
        val localDataSource = dataSourceFactory.createLocalDataSource()
        val userId = uuid ?: localDataSource.fetchSession().uuid
        val dataSource = dataSourceFactory.createFromPosts(uuid)

        dataSource.fetchUserPosts(userId, object : RequestCallback<List<Post>>{
            override fun onSucess(data: List<Post>) {
                if(uuid == null){
                    localDataSource.putPosts(data)
                }
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

    fun followUser(uuid: String?, follow: Boolean, callback: RequestCallback<Boolean>){
        val localDataSource = dataSourceFactory.createLocalDataSource()
        val userId = uuid ?: localDataSource.fetchSession().uuid
        val dataSource = dataSourceFactory.createRemoteDataSource()

        dataSource.followUser(userId, follow, object : RequestCallback<Boolean>{
            override fun onSucess(data: Boolean) {
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