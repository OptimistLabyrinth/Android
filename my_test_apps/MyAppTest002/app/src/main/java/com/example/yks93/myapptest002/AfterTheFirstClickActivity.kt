package com.example.yks93.myapptest002

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View

class AfterTheFirstClickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_the_first_click)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    fun onClick(v: View) {

        when (v.id)
        {
            R.id.searchRoommateText, R.id.searchRoommateImage ->
            {
                var i = Intent(this, LoginActivity::class.java)
                startActivity(i)
            }
            R.id.searchHouseText, R.id.searchHouseImage ->
            {
                var i = Intent()

            }
        }

    }

}
