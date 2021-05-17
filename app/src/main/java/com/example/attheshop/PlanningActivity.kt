package com.example.attheshop


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_planning.*


class PlanningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planning)

        val btnSEND = findViewById<Button>(R.id.btnSend)
        val swONE = findViewById<Switch>(R.id.acceptOrRefusal)

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
            .observe(this, Observer {
                theProposition.text = it.state.name
            })
    }
}

