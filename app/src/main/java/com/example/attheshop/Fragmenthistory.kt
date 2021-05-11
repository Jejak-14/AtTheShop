package com.example.attheshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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





    }


}