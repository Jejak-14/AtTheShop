package com.example.attheshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Get reference to button
        val btnBACK = findViewById<Button>(R.id.btnBackHome)
        val btnPLANNING = findViewById<Button>(R.id.btnPlanning)
        val btnHISTORY = findViewById<Button>(R.id.btnHistory)

        // set on-click listener
        btnBACK.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
        btnPLANNING.setOnClickListener {

            //SERVER CALL//


            Intent(this,PlanningActivity::class.java).also {
                startActivity(it)
            }
        }

        btnHISTORY.setOnClickListener {
            Intent(this,RecycleView::class.java).also{
                startActivity(it)
            }
        }

    }
}