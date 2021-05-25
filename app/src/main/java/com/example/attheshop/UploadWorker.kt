package com.example.attheshop

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {


    override fun doWork(): Result {
        return try {

            for (i in 0..30000) {
                Log.i("MYTAG", "Uploading $i")
            }


            Result.success()

        } catch (e: Exception) {
            Result.failure()
        }
        checking = true
    }
}
