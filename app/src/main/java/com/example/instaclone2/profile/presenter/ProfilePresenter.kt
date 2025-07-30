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

class ProfilePresenter(
    private var view: Profile.View?,
    private val repository: ProfileRepository
) : Profile.Presenter {

    override fun clear() {
        repository.clearCache()
    }

    override fun fetchUserProfile(uuid: String?) {
        view?.showProgress(true)
        repository.fetchUserProfile(uuid, object : RequestCallback<UserAuth> {
            override fun onSucess(data: UserAuth) {
                view?.displayUserProfile(data)
            }

            override fun onFailure(message: String) {
                view?.displayRequestFailure(message)
            }

            override fun onComplete() {
            }
        })
    }

    override fun fetchUserPosts(uuid: String?) {
        repository.fetchUserPosts(uuid, object : RequestCallback<List<Post>> {
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