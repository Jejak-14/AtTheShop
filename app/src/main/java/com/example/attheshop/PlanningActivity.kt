package com.example.attheshop


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_planning.*


class PlanningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planning)

        val btnSTART = findViewById<Button>(R.id.btnAccept)
        val sw1 = findViewById<Switch>(R.id.acceptOrRefusal)

        //Switching between the DB proposition and client input state
        sw1.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "The Proposition Is OFF" else "The Proposition Is ON"
            if (isChecked) {
                btnAccept.text = "Send Refusal"
                theRefusal.isVisible = true;
                Toast.makeText(
                    this, message,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                theRefusal.isVisible = false
                btnAccept.text = "Send Accept"

            }
        }

        // set on-click listener
        btnSTART.setOnClickListener {
            setOneTimeWorkRequest()
        }
    }

    // The Workermanager (Worker side)
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

