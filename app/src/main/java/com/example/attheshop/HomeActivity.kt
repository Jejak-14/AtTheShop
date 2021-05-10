package com.example.attheshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Get reference to button
        val btnBACK = findViewById<Button>(R.id.btnBackHome)
        val btnMENU = findViewById<Button>(R.id.btnPlanning)

        // set on-click listener
        btnBACK.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
        btnMENU.setOnClickListener {
            Intent(this,PlanningActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}