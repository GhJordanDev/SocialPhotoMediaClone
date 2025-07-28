package com.example.instaclone2.common.base

import android.content.Context
import com.example.instaclone2.add.data.AddFakeRemoteDataSource
import com.example.instaclone2.add.data.AddLocalDataSource
import com.example.instaclone2.add.data.AddRepository
import com.example.instaclone2.home.data.FeedMemoryCache
import com.example.instaclone2.home.data.HomeDataSourceFactory
import com.example.instaclone2.home.data.HomeRepository
import com.example.instaclone2.login.data.FakeDataSource
import com.example.instaclone2.login.data.LoginRepository
import com.example.instaclone2.post.data.PostLocalDataSource
import com.example.instaclone2.post.data.PostRepository
import com.example.instaclone2.profile.data.PostListMemoryCache
import com.example.instaclone2.profile.data.ProfileDataSourceFactory
import com.example.instaclone2.profile.data.ProfileMemoryCache
import com.example.instaclone2.profile.data.ProfileRepository
import com.example.instaclone2.register.data.FakeRegisterDataSource
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
        return RegisterRepository (FakeRegisterDataSource())
    }

    fun profileRepository() : ProfileRepository{
        return ProfileRepository(ProfileDataSourceFactory(ProfileMemoryCache, PostListMemoryCache))
    }

    fun homeRepository() : HomeRepository {
        return HomeRepository(HomeDataSourceFactory(FeedMemoryCache))
    }

    fun addRepository() : AddRepository {
        return AddRepository(AddFakeRemoteDataSource(), AddLocalDataSource())
    }

    fun postRepository(context: Context) : PostRepository{
        return PostRepository(PostLocalDataSource(context))
    }
}