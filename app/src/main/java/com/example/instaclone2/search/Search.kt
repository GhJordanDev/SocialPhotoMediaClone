package com.example.instaclone2.search

import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView
import com.example.instaclone2.common.model.UserAuth

interface Search {

    interface Presenter : BasePresenter {
        fun fetchUsers (name: String)
    }

    interface View : BaseView<Presenter>{
        fun showProgress(enabled: Boolean)
        fun displayFullUsers(users: List<UserAuth>)
        fun displayEmptyUser()

    }
}