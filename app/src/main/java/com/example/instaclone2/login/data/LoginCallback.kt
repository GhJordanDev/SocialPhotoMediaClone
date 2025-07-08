package com.example.instaclone2.login.data

interface LoginCallback {
    fun onSucess()
    fun onFailure(message: String)
    fun onComplete()
}