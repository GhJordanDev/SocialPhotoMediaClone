package com.example.instaclone2.add

import com.example.instaclone2.common.base.BasePresenter
import com.example.instaclone2.common.base.BaseView

interface Add {

    interface Presenter : BasePresenter{

    }

    interface View: BaseView<Presenter>{

    }
}