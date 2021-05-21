package com.example.attheshop

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.os.Bundle as Bundle

class FragmentView : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_view)

        val intent = intent
        val data = intent.getStringExtra("key")


        val firstFragment = Frist_Fragment()
        val secondFragment = Second_Fragment()

        val info = "denneInfo"
        if (data != null){
        Log.i(info, data)}

        val dato = Date(121, 4, 21)

        Log.i(info, dato.toString())

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Leopol, firstFragment)
            commit()
        }

        if (data == Date(121, 4, 21).toString()){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Leopol, firstFragment)
            commit()
        }}

        if (data == Date(121, 2, 21).toString()){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Leopol, secondFragment)
            commit()
        }}



    }




}