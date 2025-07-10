package com.example.instaclone2.login.data

import com.example.instaclone2.common.model.UserAuth

interface LoginCallback {
    fun onSucess(userAuth: UserAuth)
    fun onFailure(message: String)
    fun onComplete()
}