package com.example.instaclone2.register.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.instaclone2.R
import com.example.instaclone2.common.view.CropperImageFragment
import com.example.instaclone2.common.view.CropperImageFragment.Companion.KEY_URI
import com.example.instaclone2.databinding.ActivityRegisterBinding
import com.example.instaclone2.main.view.MainActivity
import com.example.instaclone2.register.view.RegisterNamePasswordFragment.Companion.KEY_EMAIL
import com.example.instaclone2.register.view.RegisterWelcomeFragment.Companion.KEY_NAME

class RegisterActivity : AppCompatActivity(), FragmentAttachListener {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fragment = RegisterEmailFragment()
        replaceFragment(fragment)

    }

    override fun goToNameAndPasswordScreen(email: String) {
        val fragment = RegisterNamePasswordFragment().apply{
            arguments = Bundle().apply {
                putString(KEY_EMAIL,email)
            }
        }
        replaceFragment(fragment)
    }

    override fun goToWelcomeScreen(name: String) {
        val fragment = RegisterWelcomeFragment().apply{
            arguments = Bundle().apply {
                putString(KEY_NAME,name)
            }
        }
        replaceFragment(fragment)
    }

    override fun goToPhotoScreen() {
        val fragment = RegisterPhotoFragment()
        replaceFragment(fragment)
    }

    override fun goToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private val getContent = registerForActivityResult (ActivityResultContracts.GetContent()) { uri : Uri?->
        val fragment = CropperImageFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_URI, uri)
            }
        }
        replaceFragment(fragment)
    }

    override fun goToGalleryScreen() {
        getContent.launch("image/*")
    }

    private fun replaceFragment(fragment: Fragment) {
        if (supportFragmentManager.findFragmentById(R.id.register_fragment) == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.register_fragment, fragment)
                commit()
            }
        } else{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.register_fragment, fragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}