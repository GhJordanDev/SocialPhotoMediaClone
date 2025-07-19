package com.example.instaclone2.spash.data

import com.example.instaclone2.common.model.Database

class FakeLocalDataSource : SplashDataSource {
    override fun session(callback: SplashCallback) {
        if(Database.sessionAuth != null){
            callback.onSucess()
        } else{
            callback.onFailure()
        }
    }
}