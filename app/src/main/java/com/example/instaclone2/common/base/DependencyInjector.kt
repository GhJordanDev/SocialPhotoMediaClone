package com.example.instaclone2.common.base

import com.example.instaclone2.login.data.FakeDataSource
import com.example.instaclone2.login.data.LoginRepository
import com.example.instaclone2.profile.data.ProfileFakeRemoteDataSource
import com.example.instaclone2.profile.data.ProfileRepository
import com.example.instaclone2.register.data.FakeRegisterEmailDataSource
import com.example.instaclone2.register.data.RegisterRepository
import com.example.instaclone2.spash.data.FakeLocalDataSource
import com.example.instaclone2.spash.data.SplashRepository

object DependencyInjector {

    fun splashRepository() : SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }

    fun loginRepository() : LoginRepository{
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository() : RegisterRepository{
        return RegisterRepository (FakeRegisterEmailDataSource())
    }

    fun profileRepository() : ProfileRepository{
        return ProfileRepository(ProfileFakeRemoteDataSource())
    }
}