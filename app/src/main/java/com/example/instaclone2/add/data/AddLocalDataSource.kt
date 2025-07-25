package com.example.instaclone2.add.data

import com.example.instaclone2.common.model.Database
import com.example.instaclone2.common.model.UserAuth

class AddLocalDataSource : AddDataSource {

    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?: throw RuntimeException("Usuário não logado!!")
    }
}