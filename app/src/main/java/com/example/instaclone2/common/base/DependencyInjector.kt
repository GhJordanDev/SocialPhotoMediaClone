package com.example.instaclone2.common.base

import com.example.instaclone2.login.data.FakeDataSource
import com.example.instaclone2.login.data.LoginRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository{
        return LoginRepository(FakeDataSource())
    }
}