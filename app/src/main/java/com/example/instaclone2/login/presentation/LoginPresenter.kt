package com.example.instaclone2.login.presentation

import android.util.Patterns
import com.example.instaclone2.R
import com.example.instaclone2.common.model.UserAuth
import com.example.instaclone2.login.Login
import com.example.instaclone2.login.data.LoginCallback
import com.example.instaclone2.login.data.LoginRepository

class LoginPresenter
    (private var view: Login.View?,
     private val repository: LoginRepository)
    : Login.Presenter {

    override fun login(email: String, password: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 8

        if(!isEmailValid){
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (!isPasswordValid){
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            view?.displayPasswordFailure(null)
        }

        if(isEmailValid && isPasswordValid){
            view?.showProgress(true)

            repository.login(email, password, object : LoginCallback {
                override fun onSucess(userAuth: UserAuth) {
                    view?.onUserAuthenticated()
                }

                override fun onFailure(message: String) {
                    view?.onUserUnauthorized(message)
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