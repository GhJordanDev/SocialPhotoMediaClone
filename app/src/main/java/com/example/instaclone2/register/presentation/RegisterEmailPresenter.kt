package com.example.instaclone2.register.presentation

import android.util.Patterns
import com.example.instaclone2.R
import com.example.instaclone2.common.model.UserAuth
import com.example.instaclone2.login.Login
import com.example.instaclone2.login.data.LoginCallback
import com.example.instaclone2.login.data.LoginRepository
import com.example.instaclone2.register.RegisterEmail
import com.example.instaclone2.register.data.RegisterEmailCallback
import com.example.instaclone2.register.data.RegisterEmailRepository

class RegisterEmailPresenter
    (private var view: RegisterEmail.View?,
     private val repository: RegisterEmailRepository
)
    : RegisterEmail.Presenter {

    override fun create(email: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if(!isEmailValid){
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if(isEmailValid){
            view?.showProgress(true)

            repository.create(email, object : RegisterEmailCallback {
                override fun onSucess() {
                    view?.goToNameAndPasswordScreen(email)
                }

                override fun onFailure(message: String) {
                    view?.onEmailFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            })
        }
    }

    override fun onDestroy() {
        view = null
    }
}