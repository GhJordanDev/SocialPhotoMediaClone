package com.example.instaclone2.profile.data

import com.example.instaclone2.common.base.Cache
import com.example.instaclone2.common.model.UserAuth

object ProfileMemoryCache : Cache<Pair<UserAuth, Boolean?>> {

    private var userAuth: Pair<UserAuth, Boolean?>? = null

    override fun isCached(): Boolean {
        return userAuth != null
    }

    override fun get(key: String): Pair<UserAuth, Boolean?>? {
        if(userAuth?.first?.uuid == key ) {
            return userAuth
        }
        return null
    }

    override fun put(data: Pair<UserAuth, Boolean?>?) {
        userAuth = data
    }
}