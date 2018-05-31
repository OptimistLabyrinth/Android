package com.example.yks93.myrecyclerviewpractice02.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yks93.myrecyclerviewpractice02.R;
import com.example.yks93.myrecyclerviewpractice02.pojo.StringData;

import java.util.ArrayList;
import java.util.List;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.StringViewHolder> {

    private List<StringData> dataList;

    public StringAdapter(List<StringData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public StringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.string_data_list_row, parent, false);
        return new StringViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull StringViewHolder holder, int position) {
        StringData data = dataList.get(position);
        holder.title.setText(data.getTitle());
        holder.genre.setText(data.getGenre());
        holder.year.setText(data.getYear());
    }

    @Override
    public int getItemCount() {
        return this.dataList.size();
    }

    public class StringViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView genre;
        TextView year;

        public StringViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_in_row);
            genre = (TextView) itemView.findViewById(R.id.genre_in_row);
            year = (TextView) itemView.findViewById(R.id.year_in_row);
        }
    }

}
