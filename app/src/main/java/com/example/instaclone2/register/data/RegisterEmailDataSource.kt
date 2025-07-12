package com.example.instaclone2.register.data

interface RegisterEmailDataSource {
    fun create(email: String, callback: RegisterEmailCallback ){}
}