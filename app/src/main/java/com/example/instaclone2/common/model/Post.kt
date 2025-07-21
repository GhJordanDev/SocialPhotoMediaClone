package com.example.instaclone2.common.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.sql.Timestamp
import java.util.UUID

@Parcelize
data class Post(
    val uuid: String,
    val uri: Uri,
    val caption: String,
    val timestamp: Long
) : Parcelable
