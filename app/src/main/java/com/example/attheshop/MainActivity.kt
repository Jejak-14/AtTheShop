package com.example.attheshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    val navn: ArrayList<String> = ArrayList()
    val ID: ArrayList<String> = ArrayList()
    val password: ArrayList<String> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get reference to button
        val btnIN = findViewById<Button>(R.id.logInBtn)
        val btnSUPPORT = findViewById<Button>(R.id.btnSupport)

        val brugernavn = findViewById<EditText>(R.id.editTextTextPersonName2).text
        val pw = findViewById<EditText>(R.id.editTextTextPassword).text

        loaddata()


        // set on-click listener
        btnIN.setOnClickListener {
            Toast.makeText(
                this,
                "Brugernavn " + brugernavn + " PassWord " + pw,
                Toast.LENGTH_SHORT
            ).show()


            if(brugernavn.toString() == navn[0] && pw.toString() == password[0])
            {
                Toast.makeText(
                    this,
                    "True",
                    Toast.LENGTH_SHORT).show()
                Intent(this,HomeActivity::class.java).also {
                    startActivity(it)}
            }
            if(brugernavn.toString() == navn[1] && pw.toString() == password[1])
            {
                Toast.makeText(
                    this,
                    "True",
                    Toast.LENGTH_SHORT).show()
                Intent(this,HomeActivity::class.java).also {
                    startActivity(it)}
            }
            if(brugernavn.toString() == navn[2] && pw.toString() == password[2])
            {
                Toast.makeText(
                    this,
                    "True",
                    Toast.LENGTH_SHORT).show()
                Intent(this,HomeActivity::class.java).also {
                    startActivity(it)}
            }
            if(brugernavn.toString() == navn[3] && pw.toString() == password[3])
            {
                Toast.makeText(
                    this,
                    "True",
                    Toast.LENGTH_SHORT).show()
                Intent(this,HomeActivity::class.java).also {
                    startActivity(it)}
            }
            if(brugernavn.toString() == navn[4] && pw.toString() == password[4])
            {
                Toast.makeText(
                    this,
                    "True",
                    Toast.LENGTH_SHORT).show()
                Intent(this,HomeActivity::class.java).also {
                    startActivity(it)}
            }
            else{
                Toast.makeText(
                    this,
                    "False",
                    Toast.LENGTH_SHORT).show()
            }

        }
        btnSUPPORT.setOnClickListener {
            Intent(this,SupportActivity::class.java).also {
                startActivity(it)
            }
        }


    }

    private fun loaddata() {
        val stringRequest = StringRequest(
            Request.Method.GET,
            EndPoints.URL_GETKUNDER,
            { s ->
                try {
                    val internships = JSONArray(s)

                    //Loop the Array
                    for (i in 0 until internships.length()) {
                        Log.e("Message", "ORDER")

                        val e: JSONObject = internships.getJSONObject(i)

                        navn.add(e.getString("Navn"))
                        password.add(e.getString("PW"));
                        ID.add(e.getString("Id"))

                        val tag1 = "MyActivity"
                        Log.i(tag1, navn.toString())
                    }



                } catch (e: JSONException) {
                    Log.e("log_tag", "Error parsing data $e")
                }
            },
            { volleyError ->
                Toast.makeText(
                    applicationContext,
                    volleyError.message,
                    Toast.LENGTH_LONG
                ).show()
            })

        val requestQueue = Volley.newRequestQueue(this)


        requestQueue.add<String>(stringRequest)
    }


}