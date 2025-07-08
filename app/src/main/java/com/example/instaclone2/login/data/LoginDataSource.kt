package com.example.instaclone2.login.data

interface LoginDataSource {
    fun login(email: String, password: String, callback: LoginCallback){}
}