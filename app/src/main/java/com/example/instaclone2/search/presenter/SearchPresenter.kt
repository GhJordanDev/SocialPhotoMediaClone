package com.example.instaclone2.search.presenter

import android.util.Patterns
import com.example.instaclone2.R
import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Database
import com.example.instaclone2.common.model.Post
import com.example.instaclone2.common.model.UserAuth
import com.example.instaclone2.register.RegisterEmail
import com.example.instaclone2.register.data.RegisterCallback
import com.example.instaclone2.register.data.RegisterRepository
import com.example.instaclone2.search.Search
import com.example.instaclone2.search.data.SearchRepository

class SearchPresenter(
    private var view: Search.View?,
    private val repository: SearchRepository
) : Search.Presenter {

    override fun fetchUsers(name: String) {
        repository.fetchUsers(name, object : RequestCallback<List<UserAuth>>{
            override fun onSucess(data: List<UserAuth>) {
                if(data.isEmpty()){
                    view?.displayEmptyUser()
                } else{
                    view?.displayFullUsers(data)
                }
            }

            override fun onFailure(message: String) {
                view?.displayEmptyUser()
            }

            override fun onComplete() {
                view?.showProgress(false)
            }
        })
    }

    override fun onDestroy() {
        view = null
    }
}