package com.example

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.getBundleExtra("extra")
        setContentView(R.layout.activity_detail)
        findViewById<TextView>(R.id.detail_rating).text = "${Constants.RATING}: ${bundle?.getString(Constants.RATING)}"
        findViewById<TextView>(R.id.detail_title).text = "${Constants.TITLE}: ${bundle?.getString(Constants.TITLE)}"
        findViewById<TextView>(R.id.detail_year).text = "${Constants.YEAR}: ${bundle?.getString(Constants.YEAR)}"
        findViewById<TextView>(R.id.detail_date).text = "${Constants.DATE}: ${bundle?.getString(Constants.DATE)}"
    }

    object Constants {
        const val RATING = "rating"
        const val TITLE = "title"
        const val YEAR = "year"
        const val DATE = "date"
    }
}

