package com.example.instaclone2.add

import android.net.Uri
import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView

interface Add {

    interface Presenter : BasePresenter{
        fun createPost(uri: Uri, caption: String)
    }

    interface View: BaseView<Presenter>{
        fun showProgress(enabled: Boolean)
        fun displayRequestSucess()
        fun displayRequestFailure(message: String)
    }
}