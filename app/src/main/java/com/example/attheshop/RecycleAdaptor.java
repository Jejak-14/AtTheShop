package com.example.attheshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RecycleAdaptor extends RecyclerView.Adapter<RecycleAdaptor.ViewHolder> {
    // Data which needs to be filled.
    private List<String> mData;
    private List<String> mData2;
    private List<String> mData3;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    RecycleAdaptor(Context context, List<String> data, List<String> data2, List<String> data3) {
        this.mInflater = LayoutInflater.from(context);
        // constucktor data
        this.mData = data;
        this.mData2 = data2;
        this.mData3= data3;

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycle_design, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String firstData = mData.get(position);
        holder.myTextView.setText(firstData); //tilføjer data til rows i recyclerview
        String secondData = mData2.get(position);
        holder.mySounds.setText(secondData);
        String thirdData = mData3.get(position);
        holder.myDate.setText(thirdData);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        TextView mySounds;
        TextView myDate;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.DateView);
            mySounds = itemView.findViewById(R.id.InfoView);
            myDate = itemView.findViewById(R.id.NummerPlade);
            itemView.setOnClickListener(this);
        }

        //finding which position was clicked
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}