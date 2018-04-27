package com.example.yks93.myapptest001

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setProductUI()
    }

    object Product {

        fun loadProduct(): Product {
            return this
        }

    }

    private fun setProductUI() {

    }



}


