package com.example.instaclone2.home.data

import com.example.instaclone2.common.base.Cache
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth

object FeedMemoryCache : Cache<List<Post>> {

    private var posts: List<Post>? = null

    override fun isCached(): Boolean {
        return posts != null
    }

    override fun get(key: String): List<Post>? {
        return posts
    }

    override fun put(data: List<Post>?) {
        posts = data
    }
}