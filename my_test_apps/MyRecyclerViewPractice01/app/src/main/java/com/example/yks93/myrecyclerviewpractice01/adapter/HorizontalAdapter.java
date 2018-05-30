package com.example.yks93.myrecyclerviewpractice01.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yks93.myrecyclerviewpractice01.R;
import com.example.yks93.myrecyclerviewpractice01.pojo.SingleHorizontal;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    ArrayList<SingleHorizontal> data = new ArrayList<>();

    private static final String TAG = "HorizontalAdapter";

    public HorizontalAdapter(ArrayList<SingleHorizontal> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.horizontal_single_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.image.setImageResource(data.get(position).getImage());
        holder.title.setText(data.get(position).getTitle());
        holder.desc.setText(data.get(position).getDesc());
        holder.pubDate.setText(data.get(position).getPubDate());
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView desc;
        TextView pubDate;

        private static final String TAG = "MyViewHolder";

        public MyViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "MyViewHolder: ");
            image = (ImageView) itemView.findViewById(R.id.image_horiz);
            title = (TextView) itemView.findViewById(R.id.title_horiz);
            desc = (TextView) itemView.findViewById(R.id.description_horiz);
            pubDate = (TextView) itemView.findViewById(R.id.published_date_horiz);
        }
    }

}

