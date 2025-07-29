package com.example.instaclone2.search.data

import android.os.Handler
import android.os.Looper
import android.provider.ContactsContract.Data
import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Database
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import java.util.UUID

class SearchFakeRemoteDataSource : SearchDataSource {

    override fun fetchUsers(name: String, callback: RequestCallback<List<UserAuth>>) {
        Handler(Looper.getMainLooper()).postDelayed({
            val users = Database.usersAuth.filter {
                it.name.lowercase().startsWith(name.lowercase()) && it.uuid != Database.sessionAuth!!.uuid
            }

            callback.onSucess(users.toList())

            callback.onComplete()
        }, 2000)
    }

}