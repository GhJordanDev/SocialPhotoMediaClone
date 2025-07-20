package com.example.instaclone2.profile.presenter

import android.util.Patterns
import com.example.instaclone2.R
import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Database
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import com.example.instaclone2.profile.Profile
import com.example.instaclone2.profile.data.ProfileRepository
import com.example.instaclone2.register.RegisterEmail
import com.example.instaclone2.register.data.RegisterCallback
import com.example.instaclone2.register.data.RegisterRepository

class ProfilePresenter
    (private var view: Profile.View?,
     private val repository: ProfileRepository
) : Profile.Presenter {

    override fun fetchUserProfile() {
        view?.showProgress(true)
        val userUUID = Database.sessionAuth?.uuid ?: throw RuntimeException("user not found")
        repository.fetchUserProfile(userUUID, object : RequestCallback<UserAuth> {
            override fun onSucess(data: UserAuth) {
                view?.displayUserProfile(data)
            }

            override fun onFailure(message: String) {
                view?.displayRequestFailure(message)
            }

            override fun onComplete() {
                TODO("Not yet implemented")
            }
        })
    }

    override fun fetchUserPosts() {
        val userUUID = Database.sessionAuth?.uuid ?: throw RuntimeException("user not found")
        repository.fetchUserPosts(userUUID, object : RequestCallback<List<Post>>{
            override fun onSucess(data: List<Post>) {
                if(data.isEmpty()){
                    view?.displayEmptyPosts()
                } else {
                    view?.displayFullPosts(data)
                }
            }

            override fun onFailure(message: String) {
                view?.displayRequestFailure(message)
            }

            override fun onComplete() {
                view?.showProgress(false)
            }
        })
    }

    override fun onDestroy() {
        view = null
    }
}