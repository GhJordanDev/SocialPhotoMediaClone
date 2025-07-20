package com.example.instaclone2.common.model

import android.net.Uri
import java.sql.Timestamp
import java.util.UUID

data class Post(
    val uuid: String,
    val uri: Uri,
    val caption: String,
    val timestamp: Long
)
