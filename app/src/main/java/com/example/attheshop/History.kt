package com.example.attheshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_history.*

class History : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        var historyList = mutableListOf(
            HistoryClass("This is a tester", false),
            HistoryClass("this is another test", false),
            HistoryClass(" This has to work", true)
        )

        val adaptor = HistoryAdaptor(historyList)
        RecyklerHistoryId.adapter = adaptor
        RecyklerHistoryId.layoutManager = LinearLayoutManager(this)

        btnAppRecykler.setOnClickListener{
            val title = RecyklerText.text.toString()
            val checked = HistoryClass(title, false)
            historyList.add(checked)
            adaptor.notifyItemInserted(historyList.size - 1)
        }
    }
}