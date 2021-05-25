package com.example.attheshop

import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_frist.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import android.os.Bundle as Bundle

class FragmentView : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_view)

        val intent = intent

        //get the data referance from RecycleView
        val data = intent.getStringExtra("key")

        // fragment referance
        val firstFragment = Frist_Fragment()
        val secondFragment = Second_Fragment()
        val thirdFragment = Third_Fragment()
        val fouthFragment = Fouth_Fragment()

        //Get data test
        val info = "denneInfo"
        if (data != null){
        Log.i(info, data)}

            //inserting first fragment in case of loadfail
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Leopol, firstFragment)
            commit()
        }


            // Inserting fragment with data(ordrenummer) as the indicator
        if (data == "1"){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Leopol, firstFragment);
            commit()
        }}

        if (data == "2"){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Leopol, secondFragment)
            commit()
        }}

        if (data == "3"){
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.Leopol, thirdFragment);
                commit()
            }}

        if (data == "4"){
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.Leopol, fouthFragment)
                commit()
            }}



    }



}


