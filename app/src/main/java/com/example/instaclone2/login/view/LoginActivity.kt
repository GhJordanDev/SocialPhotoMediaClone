package com.example.instaclone2.login.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instaclone2.R
import com.example.instaclone2.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            loginEditEmail.addTextChangedListener(watcher)
            loginEditPassword.addTextChangedListener(watcher)

            loginBtnEnter.setOnClickListener {
                loginBtnEnter.showProgress(true)

                loginEditEmailInput.error = "E-mail inválido"
                loginEditPasswordInput.error = "Senha incorrta"

                Handler(Looper.getMainLooper()).postDelayed({
                    loginBtnEnter.showProgress(false)
                }, 2000)
            }
        }
    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            binding.loginBtnEnter.isEnabled = p0.toString().isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {
            TODO("Not yet implemented")
        }
    }
}