package com.example.instaclone2.register.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instaclone2.R
import com.example.instaclone2.common.base.DependencyInjector
import com.example.instaclone2.common.util.TxtWatcher
import com.example.instaclone2.databinding.FragmentRegisterEmailBinding
import com.example.instaclone2.register.RegisterEmail
import com.example.instaclone2.register.presentation.RegisterEmailPresenter

class RegisterEmailFragment : Fragment(R.layout.fragment_register_email), RegisterEmail.View {

    private var binding: FragmentRegisterEmailBinding? = null
    private var fragmentAttachListener : FragmentAttachListener? = null

    override lateinit var presenter: RegisterEmail.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterEmailBinding.bind(view)

        val repository = DependencyInjector.registerEmailRepository()
        presenter = RegisterEmailPresenter(this, repository)

        binding?.let {
            with(it) {
                registerTxtLogin.setOnClickListener {
                    activity?.finish()
                }
                registerBtnNext.setOnClickListener {
                    presenter.create(registerEditEmail.text.toString())
                }
                registerEditEmail.addTextChangedListener(watcher)
                registerEditEmail.addTextChangedListener(TxtWatcher {
                    displayEmailFailure(null)
                })

            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListener){
            fragmentAttachListener = context
        }
    }

    override fun onDestroy() {
        binding = null
        fragmentAttachListener = null
        presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher {
        binding?.registerBtnNext?.isEnabled =
            binding?.registerEditEmail?.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding?.registerBtnNext?.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding?.registerEditEmailInput?.error = emailError?.let { getString(it) }
    }

    override fun onEmailFailure(message: String) {
        binding?.registerEditEmailInput?.error = message
    }

    override fun goToNameAndPasswordScreen(email: String) {
        fragmentAttachListener?.goToNameAndPasswordScreen(email )
    }
}


