package com.example.instaclone2.spash.presentation

import com.example.instaclone2.spash.Splash
import com.example.instaclone2.spash.data.SplashCallback
import com.example.instaclone2.spash.data.SplashRepository

class SplashPresenter (
    private var view: Splash.View?,
    private var repository: SplashRepository
) : Splash.Presenter {

    override fun authenticated() {
        repository.session(object : SplashCallback{
            override fun onSucess() {
                view?.goToMainScreen()
            }

            override fun onFailure() {
                view?.goToLoginScreen()
            }

        })
    }

    override fun onDestroy() {
        view = null
    }
}