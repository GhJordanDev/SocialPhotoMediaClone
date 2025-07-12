package com.example.instaclone2.register.data

import android.os.Handler
import android.os.Looper
import com.example.instaclone2.common.model.Database

class FakeRegisterEmailDataSource : RegisterEmailDataSource {

    override fun create(email: String, callback: RegisterEmailCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.usersAuth.firstOrNull{ email == it.email}

           if(userAuth == null){
               callback.onSucess()
           }else{
               callback.onFailure("Usuário já cadastrado")
           }

            callback.onComplete()
                }, 2000)
    }
}