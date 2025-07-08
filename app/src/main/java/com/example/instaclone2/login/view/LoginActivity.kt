package com.example.instaclone2.login.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instaclone2.R
import com.example.instaclone2.common.util.TxtWatcher
import com.example.instaclone2.databinding.ActivityLoginBinding
import com.example.instaclone2.login.Login
import com.example.instaclone2.login.data.FakeDataSource
import com.example.instaclone2.login.data.LoginRepository
import com.example.instaclone2.login.presentation.LoginPresenter
import com.example.instaclone2.main.view.MainActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding: ActivityLoginBinding

    override lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = LoginRepository(FakeDataSource())
        presenter = LoginPresenter(this, repository)

        with(binding) {
            loginEditEmail.addTextChangedListener(watcher)
            loginEditEmail.addTextChangedListener(TxtWatcher{
                displayEmailFailure(null)
            })
            loginEditPassword.addTextChangedListener(watcher)
            loginEditPassword.addTextChangedListener(TxtWatcher{
                displayPasswordFailure(null)
            })

            loginBtnEnter.setOnClickListener {
                //Chamar Presenter
                presenter.login(loginEditEmail.text.toString(), loginEditPassword.text.toString())


            }
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher {
        binding.loginBtnEnter.isEnabled = binding.loginEditEmail.text.toString().isNotEmpty()
                && binding.loginEditPassword.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding.loginBtnEnter.showProgress(true)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.loginEditEmailInput.error = emailError?.let{ getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.loginEditPasswordInput.error = passwordError?.let{ getString(it) }
    }

    override fun onUserAuthenticated() {
        val intent = Intent (this, MainActivity::class.java )
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun onUserUnauthorized(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}