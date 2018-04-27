package com.example.yks93.mylogin01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Login : AppCompatActivity() {

    private var name: EditText? = null
    private var password: EditText? = null
    private var info: TextView? = null
    private var Loginbtn: Button? = null
    private var counter = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initialize()

        Loginbtn?.setOnClickListener { v -> loginbtnClick(v) }
    }

    private fun initialize() {
        name = findViewById(R.id.name_input) as? EditText
        password = findViewById(R.id.password_input) as? EditText
        info = findViewById(R.id.number_counts) as? TextView
        Loginbtn = findViewById(R.id.login_button) as? Button
//        counter = 5
    }

    private fun validate(userName: String, userPassword: String) {
        if ( (userName == "Admin") && (userPassword == "1234") ) {
            var intent = Intent(this, AfterLogin::class.java)
            startActivity(intent)
        }
        else {
            --this.counter

            info?.text = "number of attempts left : ${counter}"

            if (counter.equals(0))
                Loginbtn?.isEnabled = false
        }
    }

    private fun loginbtnClick(v: View?) {
        validate(name?.text.toString(), password?.text.toString())
    }



}


