package com.example.instaclone2.post.data

import android.net.Uri

interface PostDataSource {
    suspend fun fetchPictures() :  List<Uri>
}