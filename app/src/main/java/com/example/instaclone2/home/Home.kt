package com.example.instaclone2.home

import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth

interface Home {

    interface Presenter: BasePresenter{
        fun fetchFeed()
        fun clear()
    }

    interface View : BaseView<Presenter>{
        fun showProgress(enabled: Boolean)
        fun displayRequestFailure(message: String)
        fun displayEmptyPosts()
        fun displayFullPosts(posts: List<Post>)
    }
}