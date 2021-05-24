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

    val ordreNummer: ArrayList<String> = ArrayList()
    val nummerplade: ArrayList<String> = ArrayList()
    val aendringer: ArrayList<String> = ArrayList()
    val besked: ArrayList<String> = ArrayList()
    val ordrestatus: ArrayList<String> = ArrayList()

    val navn: ArrayList<String> = ArrayList()
    val email: ArrayList<String> = ArrayList()
    val nummer: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_view)

        loaddata()


        val intent = intent
        val data = intent.getStringExtra("key")


        val firstFragment = Frist_Fragment()
        val secondFragment = Second_Fragment()



        val info = "denneInfo"
        if (data != null){
        Log.i(info, data)}


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Leopol, firstFragment)

            commit()
        }

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
                replace(R.id.Leopol, firstFragment);
                commit()
            }}

        if (data == "4"){
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.Leopol, secondFragment)
                commit()
            }}



    }


    private fun loaddata() {
        val stringRequest = StringRequest(
            Request.Method.GET,
            EndPoints.URL_ROOT,
            { s ->
                try {
                    val internships = JSONArray(s)

                    //Loop the Array
                    for (i in 0 until internships.length()) {
                        Log.e("Message", "ORDER")

                        val e: JSONObject = internships.getJSONObject(i)

                        ordreNummer.add(e.getString("Ordrenummer"))
                        nummerplade.add(e.getString("Nummerplade"))
                        aendringer.add(e.getString("Aendringer"))
                        besked.add(e.getString("Besked"))
                        ordrestatus.add(e.getString("Ordrestatus"))





                        val tag1 = "MyActivity"
                        Log.i(tag1, nummerplade.toString())
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


