package com.example.attheshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SupportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

        // Get reference to button
        val btnBackVal = findViewById<Button>(R.id.btnBack)

        // set on-click listener
        btnBackVal.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}