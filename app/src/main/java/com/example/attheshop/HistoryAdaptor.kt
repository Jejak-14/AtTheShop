package com.example.attheshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class HistoryAdaptor (
    var history: List<HistoryClass>
        ): RecyclerView.Adapter<HistoryAdaptor.HistoryViewHolder>() {

    inner class HistoryViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
    holder.itemView.apply {
        tvTitle.text = history[position].title
        cbDone.isChecked = history[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return history.size
    }
}