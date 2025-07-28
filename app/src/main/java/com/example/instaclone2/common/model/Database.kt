package com.example.instaclone2.common.model

import android.net.Uri
import java.io.File
import java.util.UUID

object Database {

    val usersAuth = mutableListOf<UserAuth>()
    val posts = hashMapOf<String, MutableSet<Post>>()
    val feeds = hashMapOf<String, MutableSet<Post>>()
    val followers = hashMapOf<String, Set<String>>()


    var sessionAuth: UserAuth? = null

    init {

        val userA = UserAuth(UUID.randomUUID().toString(), "User A","userA@gmail.com", "12345678", Uri.fromFile(
            File("")))

        val userB = UserAuth(UUID.randomUUID().toString(), "User B","userB@gmail.com", "87654321", Uri.fromFile(
            File("")))

        usersAuth.add (userA)
        usersAuth.add (userB)

        followers[userA.uuid] = hashSetOf()
        posts[userA.uuid] = hashSetOf()
        feeds[userA.uuid] = hashSetOf()

        followers[userB.uuid] = hashSetOf()
        posts[userB.uuid] = hashSetOf()
        feeds[userB.uuid] = hashSetOf()


        feeds[userA.uuid]?.addAll(
            arrayListOf(
                Post(UUID.randomUUID().toString(), Uri.fromFile(File("")), "desc", System.currentTimeMillis(), userA),

            )
        )

        feeds[userA.uuid]?.toList()?.let{
            feeds[userB.uuid]?.addAll(it)
        }

        sessionAuth = usersAuth.first()
    }

}