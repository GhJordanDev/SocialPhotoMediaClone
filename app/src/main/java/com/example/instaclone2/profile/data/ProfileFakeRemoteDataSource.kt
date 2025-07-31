package com.example.instaclone2.profile.data

import android.os.Handler
import android.os.Looper
import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Database
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import java.util.UUID

class ProfileFakeRemoteDataSource : ProfileDataSource {

    override fun fetchUserProfile(userUUID: String, callback: RequestCallback<Pair<UserAuth, Boolean?>>) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.usersAuth.firstOrNull{ userUUID == it.uuid}

            if( userAuth != null){
                if(userAuth == Database.sessionAuth ){
                    callback.onSucess(Pair(userAuth, null))
                }else{
                    val followings = Database.followers[Database.sessionAuth!!.uuid]

                    val destUser = followings?.firstOrNull{it == userUUID}
                    // destUser != null -> Estou seguindo

                    callback.onSucess(Pair(userAuth, destUser != null))

                }
            } else{
                callback.onFailure("Usuário não encontrado")
            }
            callback.onComplete()
        }, 2000)
    }

    override fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {
        Handler(Looper.getMainLooper()).postDelayed({

            val posts = Database.posts [userUUID]

            callback.onSucess(posts?.toList() ?: emptyList())

            callback.onComplete()
        }, 2000)
    }

}