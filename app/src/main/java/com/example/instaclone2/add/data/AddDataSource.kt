package com.example.instaclone2.add.data

import android.net.Uri
import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.UserAuth

interface AddDataSource {

    fun createPost(userUUID: String, uri: Uri, caption: String, callback: RequestCallback<Boolean>) {throw UnsupportedOperationException()}

    fun fetchSession() : UserAuth {throw UnsupportedOperationException()}
}