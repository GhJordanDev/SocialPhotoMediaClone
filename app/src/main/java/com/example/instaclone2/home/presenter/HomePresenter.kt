package com.example.instaclone2.home.presenter

import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import com.example.instaclone2.home.Home
import com.example.instaclone2.home.data.HomeRepository
import com.example.instaclone2.profile.Profile
import com.example.instaclone2.profile.data.ProfileRepository

class HomePresenter (
    private var view: Home.View?,
    private val repository: HomeRepository
) : Home.Presenter {

    override fun fetchFeed() {
        view?.showProgress(true)

        repository.fetchFeed( object : RequestCallback<List<Post>> {
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