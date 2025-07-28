package com.example.instaclone2.post.presenter

import android.net.Uri
import android.util.Patterns
import com.example.instaclone2.R
import com.example.instaclone2.common.base.RequestCallback
import com.example.instaclone2.common.model.Database
import com.example.instaclone2.common.model.UserAuth
import com.example.instaclone2.post.Post
import com.example.instaclone2.post.data.PostRepository
import com.example.instaclone2.profile.Profile
import com.example.instaclone2.profile.data.ProfileRepository
import com.example.instaclone2.register.RegisterEmail
import com.example.instaclone2.register.data.RegisterCallback
import com.example.instaclone2.register.data.RegisterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class PostPresenter(
    private var view: Post.View?,
    private val repository: PostRepository
) : Post.Presenter, CoroutineScope {

    private var uri: Uri? = null

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO


    override fun fetchPictures() {
        //Chamada na mainThread (UI)
        view?.showProgress(true)

        launch {
            //Dentro do launch, chamada paralela (Coroutina IO)
            val pictures = repository.fetchPictures()

            withContext(Dispatchers.Main){
                //Voltando a executar na Main Thread
                if(pictures.isEmpty()){
                    view?.displayEmptyPictures()
                }else{
                    view?.displayFullPictures(pictures)
                }
                view?.showProgress(false)
            }
        }

    }

    override fun selectedUri(uri: Uri) {
        this.uri = uri
    }

    override fun getSelectedUri(): Uri? {
        return uri
    }

    override fun onDestroy() {
        job.cancel()
        view = null
    }
}