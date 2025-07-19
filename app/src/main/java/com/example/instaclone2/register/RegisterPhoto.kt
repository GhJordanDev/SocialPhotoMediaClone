package com.example.instaclone2.register

import android.net.Uri
import androidx.annotation.StringRes
import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView

interface RegisterPhoto {

    interface Presenter : BasePresenter {
        fun updateUser(photoUri: Uri)
    }

    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)

        fun onUpdateFailure(message: String)

        fun onUpdateSucess()
    }
}