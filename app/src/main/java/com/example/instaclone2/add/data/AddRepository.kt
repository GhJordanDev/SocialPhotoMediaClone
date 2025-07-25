package com.example.instaclone2.add.data

import android.net.Uri
import com.example.instaclone2.common.base.RequestCallback

class AddRepository(
    private val remoteDataSource : AddFakeRemoteDataSource,
    private val localDataSource: AddLocalDataSource
) {
    fun createPost(uri: Uri, caption: String, callback: RequestCallback<Boolean>){
        val userAuth = localDataSource.fetchSession()

        remoteDataSource.createPost(userAuth.uuid, uri, caption, object : RequestCallback<Boolean>{
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