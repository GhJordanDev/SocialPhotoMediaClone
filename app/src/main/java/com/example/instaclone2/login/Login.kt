package com.example.instaclone2.login

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
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized()
    }

}