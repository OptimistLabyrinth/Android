package com.example.yks93.myapptest002

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class WelcomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)
        findViewById<android.support.constraint.ConstraintLayout>(R.id.constraintLayout_welcome_page)
            .setOnClickListener { v -> welcomPageClicked(v) }
    }

    private fun welcomPageClicked(v: View) {
        var intent = Intent(this, AfterTheFirstClickActivity::class.java)
        startActivity(intent)
    }

}
