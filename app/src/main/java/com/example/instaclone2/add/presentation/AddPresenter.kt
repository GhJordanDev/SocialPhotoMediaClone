package com.example.instaclone2.add.presentation

import android.net.Uri
import com.example.instaclone2.add.Add
import com.example.instaclone2.add.data.AddRepository
import com.example.instaclone2.common.base.RequestCallback

class AddPresenter(
    private var view : Add.View? = null,
    private val repository: AddRepository
) : Add.Presenter{

    override fun createPost(uri: Uri, caption: String) {
        view?.showProgress(true)
        repository.createPost(uri, caption, object : RequestCallback<Boolean>{
            override fun onSucess(data: Boolean) {
                if(data){
                    view?.displayRequestSucess()
                }else{
                    view?.displayRequestFailure("internal error")
                }
            }

            override fun onFailure(message: String) {
                view?.displayRequestFailure(message)
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