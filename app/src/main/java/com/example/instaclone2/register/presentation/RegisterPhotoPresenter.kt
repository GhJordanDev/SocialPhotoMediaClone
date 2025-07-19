package com.example.instaclone2.register.presentation

import android.net.Uri
import com.example.instaclone2.R
import com.example.instaclone2.register.RegisterNameAndPassword
import com.example.instaclone2.register.RegisterPhoto
import com.example.instaclone2.register.data.RegisterCallback
import com.example.instaclone2.register.data.RegisterRepository

class RegisterPhotoPresenter
    (
    private var view: RegisterPhoto.View?,
    private val repository: RegisterRepository
) : RegisterPhoto.Presenter {

    override fun updateUser(photoUri: Uri) {
        view?.showProgress(true)

        repository.updateUser(photoUri, object : RegisterCallback {
            override fun onSucess() {
                view?.onUpdateSucess()
            }

            override fun onFailure(message: String) {
                view?.onUpdateFailure(message)
            }

            override fun onComplete() {
                view?.showProgress(false)
            }
        })
    }

    override fun onDestroy() {
        view = null
    }

}