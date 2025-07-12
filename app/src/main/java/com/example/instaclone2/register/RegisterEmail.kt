package com.example.instaclone2.register

import androidx.annotation.StringRes
import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView
import java.lang.Error

interface RegisterEmail {

    interface Presenter : BasePresenter{
        fun create(email: String)
    }

    interface View: BaseView<Presenter>{
        fun showProgress(enabled: Boolean)

        fun displayEmailFailure(@StringRes emailError: Int?)

        fun onEmailFailure(message: String)

        fun goToNameAndPasswordScreen(email: String)
    }
}