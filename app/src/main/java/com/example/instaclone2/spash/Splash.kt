package com.example.instaclone2.spash

import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView

interface Splash {

    interface Presenter : BasePresenter{
        fun authenticated()
    }

    interface View : BaseView<Presenter>{
        fun goToMainScreen()
        fun goToLoginScreen()
    }
}