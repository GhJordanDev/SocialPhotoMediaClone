package com.example.instaclone2.register.data

interface RegisterCallback {
    fun onSucess()
    fun onFailure(message: String)
    fun onComplete()
}