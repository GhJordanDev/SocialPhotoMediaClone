package com.example.instaclone2.common.base

import com.example.instaclone2.login.data.FakeDataSource
import com.example.instaclone2.login.data.LoginRepository
import com.example.instaclone2.register.data.FakeRegisterEmailDataSource
import com.example.instaclone2.register.data.RegisterEmailRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository{
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository() : RegisterEmailRepository{
        return RegisterEmailRepository (FakeRegisterEmailDataSource())
    }
}