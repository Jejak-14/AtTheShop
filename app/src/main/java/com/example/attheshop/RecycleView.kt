package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycle_view.*
import java.util.*
import kotlin.collections.ArrayList


class RecycleView : AppCompatActivity(), RecycleAdaptor.ItemClickListener {
    var adapter: RecycleAdaptor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        // data to populate the first column of the RecyclerView with (test)
        val navn: ArrayList<String> = ArrayList()
        navn.add("Kasper")
        navn.add("Michelle")
        navn.add("Jens")
        navn.add("Nickolai")
        navn.add("Anders")

        // data to populate the second column of the RecyclerView with (test)
        val nummer: ArrayList<String> = ArrayList()
        nummer.add("15384159")
        nummer.add("65982314")
        nummer.add("78915213")
        nummer.add("98643721")
        nummer.add("68318462")

        val dato: ArrayList<String> = ArrayList()
        dato.add(Date(121, 4, 21).toString())
        dato.add(Date(121, 2, 21).toString())
        dato.add(Date(121, 1, 21).toString())
        dato.add(Date(120, 11, 21).toString())
        dato.add(Date(120, 6, 21).toString())


        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.RecycleViewHolderid)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecycleAdaptor(this, dato, nummer, navn)
        adapter!!.setClickListener(this)
        recyclerView.adapter = adapter
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

    override fun onItemClick(view: View?, position: Int) {
        Toast.makeText(
            this,
            "You clicked " + adapter!!.getItem(position) + " on row number " + position,
            Toast.LENGTH_SHORT
        ).show()
        val intent = Intent(this, FragmentView::class.java);
        intent.putExtra("key", adapter!!.getItem(position));
        startActivity(intent);
    }
}
