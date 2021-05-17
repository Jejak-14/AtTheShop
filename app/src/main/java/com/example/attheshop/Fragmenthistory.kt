package com.example.attheshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmenthistory.*

class Fragmenthistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmenthistory)

        val firstFragment = Frist_Fragment()
        val secondFragment = Second_Fragment()

        supportFragmentManager.beginTransaction().apply{
            replace(R.id.flfragment, firstFragment)
            commit()
        }

        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flfragment, firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flfragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }




    }


}