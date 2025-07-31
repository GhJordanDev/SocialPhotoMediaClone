package com.example.instaclone2.profile

import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth

interface Profile {

    interface Presenter : BasePresenter {
        fun fetchUserProfile(uuid: String?)
        fun fetchUserPosts(uuid: String?)
        fun clear()
    }

    interface View : BaseView<Presenter>{
        fun showProgress(enabled: Boolean)
        fun displayUserProfile(userAuth: Pair<UserAuth, Boolean?>)
        fun displayRequestFailure(message: String)
        fun displayEmptyPosts()
        fun displayFullPosts(posts: List<Post>)
    }
}