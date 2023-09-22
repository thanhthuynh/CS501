package com.example.assignment1application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myName = "Thanh"
        val myTextView: TextView = findViewById(R.id.myTextView)

        myTextView.text = getString(R.string.greeting_text, myName)
    }
}
