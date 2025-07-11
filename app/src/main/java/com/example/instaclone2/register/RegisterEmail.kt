package com.example.instaclone2.register

import androidx.annotation.StringRes
import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView
import java.lang.Error

interface RegisterEmail {

    interface Presenter : BasePresenter{

    }

    interface View: BaseView<Presenter>{
        fun displayEmailFailure(@StringRes emailError: Int?)
    }
}