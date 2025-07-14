package com.example.instaclone2.register.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instaclone2.R
import com.example.instaclone2.common.view.CustomDialog
import com.example.instaclone2.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment : Fragment(R.layout.fragment_register_photo) {

    private var binding: FragmentRegisterPhotoBinding? = null
    private var fragmentAttachListener: FragmentAttachListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterPhotoBinding.bind(view)

        binding?.let {
            with(it){
                registerBtnJump.setOnClickListener{
                    fragmentAttachListener?.goToMainScreen()
                }

                registerBtnNext.isEnabled = true
                registerBtnNext.setOnClickListener{
                    val customDialog = CustomDialog(requireContext())
                    customDialog.setTitle(R.string.app_name)
                    customDialog.addButton(R.string.photo, R.string.gallery){
                        when(it.id){
                            R.string.photo -> {
                                Log.i("Teste", "Foto")
                            }
                            R.string.gallery -> {
                                Log.i("Teste", "Galeria")
                            }
                        }
                    }
                    customDialog.show()
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
}