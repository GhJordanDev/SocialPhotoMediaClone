package com.example.instaclone2.register.data

import com.example.instaclone2.common.model.UserAuth

interface RegisterEmailCallback {
    fun onSucess()
    fun onFailure(message: String)
    fun onComplete()
}