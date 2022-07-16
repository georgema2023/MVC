package com.example.model

import com.example.controller.MainController
import java.util.*

class MainModel(val controller:MainController) {
    lateinit var mList :ArrayList<ResultEntity>

    fun findAddress(){
        mList = ArrayList<ResultEntity>()
        mList.add(ResultEntity("1","1","1","1"))
        mList.add(ResultEntity("2","2","2","2"))
        controller.doWhenResultIsReady()
    }

    class ResultEntity(val title:String, val rating:String, val date:String, val year:String)
}