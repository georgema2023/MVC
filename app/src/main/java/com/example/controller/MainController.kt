package com.example.controller

import android.content.Intent
import android.os.Bundle
import com.example.DetailActivity
import com.example.MainActivity
import com.example.model.MainModel

class MainController {
    private lateinit var mainView:MainActivity
    private lateinit var mainModel:MainModel

    infix fun hasView(mainActivity: MainActivity){
        mainView = mainActivity
    }

    infix fun hasModel(mainModel:MainModel){
        this.mainModel = mainModel
    }

    fun findAddress(){
        mainView.showProgressBar()
        mainModel.findAddress()
    }

    fun doWhenResultIsReady(){
        mainView.hideProgressBar()
        mainView.showResult()
    }

    infix fun doWhenClickIsMadeOn(item:MainModel.ResultEntity){
        var bundle = Bundle()
        bundle.putString(DetailActivity.Constants.RATING, item.rating)
        bundle.putString(DetailActivity.Constants.TITLE, item.title)
        bundle.putString(DetailActivity.Constants.YEAR, item.year)
        bundle.putString(DetailActivity.Constants.DATE, item.date)
        var intent = Intent(mainView, DetailActivity::class.java)
        intent.putExtras(bundle)
        mainView.startActivity(intent)
    }

}