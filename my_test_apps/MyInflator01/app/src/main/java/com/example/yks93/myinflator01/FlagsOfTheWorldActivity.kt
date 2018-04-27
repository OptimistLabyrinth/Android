package com.example.yks93.myinflator01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class FlagsOfTheWorldActivity : AppCompatActivity() {

    val COUNTRIES = arrayOf(
        "Australia", "Brazil", "China", "Egypt", "France", "Germany",
        "Ghana", "Italy", "Japan", "Mexico", "Nepal", "Nigeria",
        "United Kingdom", "United States")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags_of_the_world)

        var layout= findViewById<GridLayout>(R.id.activity_flags)

        for (name in COUNTRIES)
            addFlag(name, layout)
    }

    private fun addFlag(countryName: String, layout: GridLayout) {
        var flag = layoutInflater.inflate(R.layout.flag, null)
        var tv = flag.findViewById<TextView>(R.id.textview_flag)
        tv.text = countryName

        var countryName = countryName.replace(" ", "_").toLowerCase()
        var flagimageID = resources.getIdentifier(countryName, "drawable", packageName)

        var iv = flag.findViewById<ImageButton>(R.id.imageview_flag).apply {
            setImageResource(flagimageID)
            setOnClickListener{ ivOnClick(it, countryName) }
        }

        layout.addView(flag)
    }

    private fun ivOnClick(v: View?, countryName: String) {
        Toast.makeText(this, "You clicked " + countryName, Toast.LENGTH_SHORT).show()
    }

}
