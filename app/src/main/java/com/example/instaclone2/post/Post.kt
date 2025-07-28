package com.example.instaclone2.post

import android.net.Uri
import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth

interface Post {

    interface Presenter : BasePresenter{
        fun fetchPictures()
    }

    interface View: BaseView<Presenter>{
        fun showProgress(enabled: Boolean)
        fun displayRequestFailure(message: String)
        fun displayEmptyPictures()
        fun displayFullPictures(posts: List<Uri>)
    }
}