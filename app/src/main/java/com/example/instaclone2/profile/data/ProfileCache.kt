package com.example.instaclone2.profile.data

interface ProfileCache <T>{
    fun isCached() : Boolean
    fun get(key: String) : T?
    fun put(data: T)
}