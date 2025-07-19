package com.example.instaclone2.spash.data

class SplashRepository(private val dataSource: SplashDataSource) {

    fun session(callback: SplashCallback){
        dataSource.session(callback)
    }
}