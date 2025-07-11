package com.example.instaclone2.login

import androidx.annotation.StringRes
import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView

interface Login {

    //Camada Presenter
    interface Presenter : BasePresenter{
        fun login(email: String, password: String)

    }

    //Camada View
    interface View : BaseView <Presenter>{
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun displayPasswordFailure(@StringRes passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }

}