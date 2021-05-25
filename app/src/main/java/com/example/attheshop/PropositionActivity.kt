package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Xml
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_planning.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.Arrays.toString
import kotlin.Unit.toString

class PropositionActivity : AppCompatActivity() {

    private var theView: TextView? = null

    // Local Arrays of the tables from DB //
    val ordreNummer: ArrayList<String> = ArrayList()
    val nummerplade: ArrayList<String> = ArrayList()
    val aendringer: ArrayList<String> = ArrayList()
    val besked: ArrayList<String> = ArrayList()
    val ordrestatus: ArrayList<String> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planning)

        // Send button //
        val btnSEND = findViewById<Button>(R.id.btnSend)

        // Accept/Refusal switch //
        val swONE = findViewById<Switch>(R.id.acceptOrRefusal)

        // Find textview and start to fill it with data //
        theView = findViewById(R.id.theProposition)
        loaddata()


        // Switching between the DB proposition and client input state //
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

        // Sent accept or refusal //
        btnSEND.setOnClickListener {
            setOneTimeWorkRequest()
        }
    }

    // The work manager (Manager side) //
    private fun setOneTimeWorkRequest() {
        val workManager: WorkManager = WorkManager.getInstance(applicationContext)
        val uploadRequest: OneTimeWorkRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .build()
        workManager.enqueue(uploadRequest)
        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(this, {

                // display the status //
                theProposition.text = it.state.name
            })
    }

    // Find data through URL and fill in the local arrays variants //
    private fun loaddata() {
        val stringRequest = StringRequest(Request.Method.GET,
            EndPoints.URL_GETORDRE,
            { s ->
                try {
                    val internships = JSONArray(s)

                    // Fill in the local arrays variants //
                    for (i in 0 until internships.length()) {
                        Log.e("Message", "ORDRE")

                        val e: JSONObject = internships.getJSONObject(i)

                        ordreNummer.add(e.getString("Ordrenummer"))
                        nummerplade.add(e.getString("Nummerplade"))
                        aendringer.add(e.getString("Aendringer"))
                        besked.add(e.getString("Besked"))
                        ordrestatus.add(e.getString("Ordrestatus"))

                        // Show the results in the view //
                        theView?.text = e.toString()

                    }
                } catch (e: JSONException) {
                    Log.e("log_tag", "Error parsing data $e")
                }
            },
            // Fail Toast //
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
