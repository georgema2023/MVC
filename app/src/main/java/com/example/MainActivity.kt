package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.controller.MainController
import com.example.model.MainModel
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mMainController:MainController
    private lateinit var mMainModel: MainModel
    private lateinit var addressAdapter:AddressAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMainController = MainController()
        mMainModel = MainModel(mMainController)
        mMainController hasView this;
        mMainController hasModel mMainModel;
        addressAdapter = AddressAdapter { mMainController doWhenClickIsMadeOn it }
        findViewById<RecyclerView>(R.id.main_activity_recyclerView).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.main_activity_recyclerView).adapter = addressAdapter

        findViewById<Button>(R.id.main_activity_button).setOnClickListener {
            mMainController.findAddress()
        }
    }

    fun showProgressBar(){
        findViewById<ProgressBar>(R.id.main_activity_progress_bar).visibility = View.VISIBLE
    }

    fun hideProgressBar(){
        findViewById<ProgressBar>(R.id.main_activity_progress_bar).visibility = View.GONE
    }

    fun showResult(){
        addressAdapter.updateList(mMainModel.mList)
        addressAdapter.notifyDataSetChanged()
    }

    class AddressAdapter(val onClick:(item: MainModel.ResultEntity)->Unit): RecyclerView.Adapter<AddressAdapter.Holder>() {
        var mList:List<MainModel.ResultEntity> = ArrayList()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
            return Holder(view)
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.itemView.findViewById<TextView>(R.id.item_textView).text = "${mList[position].year}:${mList[position].title}"
            holder.itemView.setOnClickListener{onClick(mList[position])}
        }

        override fun getItemCount(): Int {
            return mList.size
        }

        fun updateList(list:List<MainModel.ResultEntity>){
            mList = list;
        }
        class Holder(itemView: View): RecyclerView.ViewHolder(itemView)
    }
}