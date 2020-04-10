package com.example.testing.mock.rx.presenter

open class BasePresenter <V>(var view: V? = null){




    fun detachView() {
        view = null
    }


}