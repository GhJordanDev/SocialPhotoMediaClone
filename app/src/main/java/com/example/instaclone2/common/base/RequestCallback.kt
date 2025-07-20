package com.example.instaclone2.common.base

interface RequestCallback<T> {
    fun onSucess(data: T)
    fun onFailure(message: String)
    fun onComplete()
}