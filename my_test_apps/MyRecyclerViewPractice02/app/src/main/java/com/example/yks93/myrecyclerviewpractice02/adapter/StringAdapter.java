package com.example.yks93.myrecyclerviewpractice02.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yks93.myrecyclerviewpractice02.R;
import com.example.yks93.myrecyclerviewpractice02.pojo.StringData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

        @BindView(R.id.image_in_row)
        ImageView image;
        @BindView(R.id.title_in_row)
        TextView title;
        @BindView(R.id.genre_in_row)
        TextView genre;
        @BindView(R.id.year_in_row)
        TextView year;

        ArrayList<TextView> tvList = new ArrayList<>();
        private int on_off = 1;

        public StringViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

//            image = (ImageView) itemView.findViewById(R.id.image_in_row);
//            title = (TextView) itemView.findViewById(R.id.title_in_row);
//            genre = (TextView) itemView.findViewById(R.id.genre_in_row);
//            year = (TextView) itemView.findViewById(R.id.year_in_row);

            tvList.add(title);
            tvList.add(genre);
            tvList.add(year);

            image.setOnClickListener(v -> {

                if (on_off == 1) {
                    for (TextView tv : tvList) {
                        tv.setVisibility(View.INVISIBLE);
                    }
                    on_off = 0;
                } else {
                    for (TextView tv : tvList) {
                        tv.setVisibility(View.VISIBLE);
                    }
                    on_off = 1;
                }

            });
        }
    }

}
