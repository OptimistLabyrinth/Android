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
import com.example.yks93.myrecyclerviewpractice01.pojo.SingleVertical;

import java.util.ArrayList;
import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {

    private ArrayList<SingleVertical> data = new ArrayList<>();

    private final String TAG = "VerticalAdapter";

    public VerticalAdapter(ArrayList<SingleVertical> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.vertical_single_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.image.setImageResource(data.get(position).getImage());
        holder.title.setText(data.get(position).getHeader());
        holder.desc.setText(data.get(position).getSubHeader());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return this.data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView desc;

        private static final String TAG = "MyViewHolder";

        public MyViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "MyViewHolder: ");
            image = (ImageView) itemView.findViewById(R.id.image_vert);
            title = (TextView) itemView.findViewById(R.id.title_vert);
            desc = (TextView) itemView.findViewById(R.id.descripton_vert);
        }
    }


}
