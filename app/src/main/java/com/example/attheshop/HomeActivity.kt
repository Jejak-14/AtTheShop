package com.example.attheshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Get reference to button //
        val btnBACK = findViewById<Button>(R.id.btnBackHome)
        val btnPROPOSITION = findViewById<Button>(R.id.btnProposition)
        val btnHISTORY = findViewById<Button>(R.id.btnHistory)

        // Back button //
        btnBACK.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }

        // Proposition button //
        btnPROPOSITION.setOnClickListener {
            Intent(this,PropositionActivity::class.java).also {
                startActivity(it)
            }
        }

        // History button //
        btnHISTORY.setOnClickListener {
            Intent(this,RecycleView::class.java).also{
                startActivity(it)
            }
        }
    }

    //onStart is is called when activity is visible to the user.
    override fun onStart() {
        super.onStart()

    }

    //onResume is called when the activity is going to the foreground.
    override fun onResume() {
        super.onResume()

    }

    //onRestart is called when you stop the activity after it has already been running.
    override fun onRestart() {
        super.onRestart()
    }

    //onPause is called when an activity goes to the background.
    override fun onPause() {
        super.onPause()

    }

    //onStop is called when the activity is no longer visible but can still save data.
    override fun onStop() {
        super.onStop()

    }

    //onDestroy is called as the last thing in the activity right before it's destroyed.
    override fun onDestroy() {
        super.onDestroy()

    }
}