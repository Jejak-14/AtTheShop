package com.example.attheshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_home.*

class History : AppCompatActivity(), HistoryAdaptor.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)




            val historyList = mutableListOf(
                HistoryClass("This is a tester", false),
                HistoryClass("this is another test", false),
                HistoryClass(" This has to work", true)
            )


            val adaptor = HistoryAdaptor(historyList, this)
            RecyklerHistoryId.adapter = adaptor
            RecyklerHistoryId.layoutManager = LinearLayoutManager(this)





            btnAppRecykler.setOnClickListener {
                val title = RecyklerText.text.toString()
                val checked = HistoryClass(title, false)
                historyList.add(checked)
                adaptor.notifyItemInserted(historyList.size - 1)
            }


        }




        override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()

    }

}