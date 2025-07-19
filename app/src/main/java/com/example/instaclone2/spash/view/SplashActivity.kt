package com.example.instaclone2.spash.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instaclone2.R
import com.example.instaclone2.common.base.DependencyInjector
import com.example.instaclone2.common.extension.animatorEnd
import com.example.instaclone2.databinding.ActivitySplashBinding
import com.example.instaclone2.login.view.LoginActivity
import com.example.instaclone2.main.view.MainActivity
import com.example.instaclone2.spash.Splash
import com.example.instaclone2.spash.data.SplashRepository
import com.example.instaclone2.spash.presentation.SplashPresenter

class SplashActivity : AppCompatActivity(), Splash.View {

    private lateinit var binding : ActivitySplashBinding

    override lateinit var presenter: Splash.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = DependencyInjector.splashRepository()
        presenter = SplashPresenter(this, repository)

        binding.splashImg.animate().apply {
            setListener(animatorEnd {
                presenter.authenticated()
            })
            duration = 1000
            alpha(1.0f)
            start()
        }

        presenter.authenticated()

    }

    override fun goToMainScreen() {
        binding.splashImg.animate().apply {
            setListener(animatorEnd {
                val intent = Intent (baseContext, MainActivity::class.java )
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            })
            duration = 1000
            startDelay = 1000
            alpha(0.0f)
            start()
        }
    }

    override fun goToLoginScreen() {
        binding.splashImg.animate().apply {
            setListener(animatorEnd {
                val intent = Intent (baseContext, LoginActivity::class.java )
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            })
            duration = 1000
            startDelay = 1000
            alpha(0.0f)
            start()
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}