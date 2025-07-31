package com.example.instaclone2.profile.data

import com.example.instaclone2.common.base.Cache
import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Database
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth

class ProfileLocalDataSource(
    private val profileCache : Cache<Pair<UserAuth, Boolean?>>,
    private val postsCache : Cache<List<Post>>
) : ProfileDataSource {

    override fun fetchUserProfile(userUUID: String, callback: RequestCallback<Pair<UserAuth, Boolean?>>) {
       val userAuth = profileCache.get(userUUID)
        if(userAuth != null){
            callback.onSucess(userAuth)
        } else{
            callback.onFailure("Usuário não encontrado")
        }
        callback.onComplete()
    }

    override fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {
        val posts = postsCache.get(userUUID)
        if(posts != null){
            callback.onSucess(posts)
        }else{
            callback.onFailure("posts não existem")
        }
        callback.onComplete()
    }

    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?: throw RuntimeException ("usuário não logado")   }

    override fun putUser(response: Pair<UserAuth, Boolean?>) {
        profileCache.put(response)
    }

    override fun putPosts(response: List<Post>?) {
        postsCache.put(response)
    }


}