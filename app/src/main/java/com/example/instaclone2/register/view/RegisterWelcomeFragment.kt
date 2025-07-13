package com.example.instaclone2.register.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.instaclone2.R
import com.example.instaclone2.common.base.DependencyInjector
import com.example.instaclone2.common.util.TxtWatcher
import com.example.instaclone2.databinding.FragmentRegisterNamePasswordBinding
import com.example.instaclone2.databinding.FragmentRegisterWelcomeBinding
import com.example.instaclone2.register.RegisterNameAndPassword
import com.example.instaclone2.register.presentation.RegisterNameAndPasswordPresenter

class RegisterWelcomeFragment : Fragment(R.layout.fragment_register_welcome) {

    private var binding: FragmentRegisterWelcomeBinding? = null
    private var fragmentAttachListener : FragmentAttachListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterWelcomeBinding.bind(view)

        val name = arguments?.getString(KEY_NAME) ?:throw IllegalArgumentException("Name not found")

        binding?.let {
            with(it){
                registerTxtWelcome.text = getString(R.string.welcome_to_instagram, name)

                registerBtnNext.isEnabled = true
                registerBtnNext.setOnClickListener{
                    fragmentAttachListener?.goToPhotoScreen()
                }
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
        super.onDestroy()
    }

    companion object{
        const val KEY_NAME = "key_name"
    }
}