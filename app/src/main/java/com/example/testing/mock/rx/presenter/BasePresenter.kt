package com.example.testing.mock.rx.presenter

open class BasePresenter <V>{

     var view: V? = null

    fun attachView(view: V){
    this.view = view
    }


    fun detachView() {
        view = null
    }


}