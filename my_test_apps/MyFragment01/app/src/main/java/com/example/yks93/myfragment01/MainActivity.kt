package com.example.yks93.myfragment01

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()
    }

    private fun addFragment() {
        var frManager = getSupportFragmentManager()
        var frTransaction = frManager.beginTransaction()
        var sampleFragment = SampleFragment02()
        frTransaction.add(R.id.fragmentContainer, sampleFragment)
        frTransaction.commit()

    }

}
