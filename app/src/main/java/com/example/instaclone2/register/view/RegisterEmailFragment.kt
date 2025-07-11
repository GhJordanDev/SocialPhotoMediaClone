package com.example.instaclone2.register.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instaclone2.R
import com.example.instaclone2.common.util.TxtWatcher
import com.example.instaclone2.databinding.FragmentRegisterEmailBinding
import com.example.instaclone2.register.RegisterEmail

class RegisterEmailFragment : Fragment(R.layout.fragment_register_email), RegisterEmail.View {

    private var binding: FragmentRegisterEmailBinding? = null

    override lateinit var presenter: RegisterEmail.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterEmailBinding.bind(view)

        binding?.let{
            with(it){
                registerTxtLogin.setOnClickListener{
                    activity?.finish()
                }

                registerBtnNext.setOnClickListener{
                    presenter.create(registerEditEmail.text.toString())
                }

                registerEditEmail.addTextChangedListener(watcher)
                registerEditEmail.addTextChangedListener(TxtWatcher{
                    displayEmailFailure(null)
                })

            }
        }
    }

    override fun onDestroy() {
        binding = null
       // presenter.onDestroy()
        super.onDestroy()
    }

    private val watcher = TxtWatcher {
        binding?.registerBtnNext?.isEnabled = binding?.registerEditEmail?.text.toString().isNotEmpty()
    }

    override fun displayEmailFailure(emailError: Int?) {
        TODO("Not yet implemented")
    }
}