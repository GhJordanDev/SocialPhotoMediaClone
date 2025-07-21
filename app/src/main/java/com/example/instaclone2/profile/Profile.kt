package com.example.instaclone2.profile

import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth

interface Profile {

    interface StatefulPresenter<S: State> : BasePresenter{
        fun subscribe(state: S?)
        fun getState() : S
    }

    interface State {
        fun fetchUserProfile() :  UserAuth?
        fun fetchUserPosts() : List<Post>?
    }

    interface Presenter : StatefulPresenter<State>{
    }

    interface View : BaseView<Presenter>{
        fun showProgress(enabled: Boolean)
        fun displayUserProfile(userAuth: UserAuth)
        fun displayRequestFailure(message: String)
        fun displayEmptyPosts()
        fun displayFullPosts(posts: List<Post>)
    }
}