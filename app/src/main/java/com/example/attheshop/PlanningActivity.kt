package com.example.attheshop

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_planning.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class PlanningActivity : AppCompatActivity() {

    private var theView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planning)

        val btnSEND = findViewById<Button>(R.id.btnSend)
        val swONE = findViewById<Switch>(R.id.acceptOrRefusal)

        theView = findViewById(R.id.theProposition)
        loaddata()
        displayData()

        //Switching between the DB proposition and client input state
        swONE.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "The Proposition Is OFF" else "The Proposition Is ON"
            if (isChecked) {
                btnSend.text = "Send Refusal"
                theRefusal.isVisible = true
                Toast.makeText(
                    this, message,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                theRefusal.isVisible = false
                btnSend.text = "Send Accept"
            }
        }

        // Sent accept or refusal
        btnSEND.setOnClickListener {
            setOneTimeWorkRequest()
        }
    }

    // The work manager (Manager side)
    private fun setOneTimeWorkRequest() {
        val workManager: WorkManager = WorkManager.getInstance(applicationContext)
        val uploadRequest: OneTimeWorkRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .build()
        workManager.enqueue(uploadRequest)
        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(this, {
                theProposition.text = it.state.name
            })
    }

    private fun loaddata() {
        val stringRequest = StringRequest(Request.Method.GET,
            EndPoints.URL_GETDATA,
            { s ->
                try {
                    val internships = JSONArray(s)

                    //Loop the Array
                    for (i in 0 until internships.length()) {
                        Log.e("Message", "ORDRE")

                        val map = HashMap<String, String>()
                        val e: JSONObject = internships.getJSONObject(i)

                        map["Ordrenummer:"] = e.getString("Ordrenummer")
                        map["Pris:"] = e.getString("Pris")
                        map["Nummerplade:"] = e.getString("Nummerplade")
                        map["Aendringer:"] = e.getString("Aendringer")
                        map["Besked:"] = e.getString("Besked")

                        val tag1 = "MyActivity"
                        Log.i(tag1, map.toString())

                        theView?.text = map.toString()
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
        requestQueue.add(stringRequest)
    }

    private fun displayData() {
        theView?.text = "hejhej"
        /*theView?.setText(textdata)*/

    }
}
