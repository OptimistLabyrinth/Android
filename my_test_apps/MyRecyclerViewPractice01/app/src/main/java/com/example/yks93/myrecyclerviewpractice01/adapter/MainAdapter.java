package com.example.yks93.myrecyclerviewpractice01.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yks93.myrecyclerviewpractice01.R;
import com.example.yks93.myrecyclerviewpractice01.pojo.SingleHorizontal;
import com.example.yks93.myrecyclerviewpractice01.pojo.SingleVertical;

import java.util.ArrayList;

import static com.example.yks93.myrecyclerviewpractice01.MainActivity.getHorizontalData;
import static com.example.yks93.myrecyclerviewpractice01.MainActivity.getVerticalData;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Object> items;

    private final int VERTICAL = 1;
    private final int HORIZONTAL = 2;
    private final String TAG = "MainAdapter";

    public MainAdapter(Context context, ArrayList<Object> items) {
        Log.d(TAG, "MainAdapter: ");
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater = LayoutInflater.from(context);
        Log.d(TAG, "onCreateViewHolder: inflater = " + inflater.toString());
        View view;
        RecyclerView.ViewHolder holder;

        switch (viewType)
        {
            case VERTICAL:
                Log.d(TAG, "onCreateViewHolder: case - VERTICAL");
                view = inflater.inflate(R.layout.vertical, parent, false);
                Log.d(TAG, "onCreateViewHolder: view = " + view.toString());
                holder = new VerticalViewHolder(view);
                Log.d(TAG, "onCreateViewHolder: holder = " + holder.toString());
                break;

            case HORIZONTAL:
            default:
                Log.d(TAG, "onCreateViewHolder: case - HORIZONTAL/Default");
                view = inflater.inflate(R.layout.horizontal, parent, false);
                Log.d(TAG, "onCreateViewHolder: view = " + view.toString());
                holder = new HorizontalViewHolder(view);
                Log.d(TAG, "onCreateViewHolder: holder = " + holder.toString());
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        if (holder.getItemViewType() == VERTICAL) {
            setVerticalView((VerticalViewHolder) holder);
        } else if (holder.getItemViewType() == HORIZONTAL) {
            setHorizontalView((HorizontalViewHolder) holder);
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return this.items.size();
    }

    private void setVerticalView(VerticalViewHolder holder) {
        Log.d(TAG, "setVerticalView: ");
        VerticalAdapter adapterV = new VerticalAdapter(getVerticalData());
        Log.d(TAG, "setVerticalView: adapterV = " + adapterV.toString());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapterV);
        Log.d(TAG, "setVerticalView: holder = " + holder.toString());
    }

    private void setHorizontalView(HorizontalViewHolder holder) {
        Log.d(TAG, "setHorizontalView: ");
        HorizontalAdapter adapterH = new HorizontalAdapter(getHorizontalData());
        Log.d(TAG, "setHorizontalView: adapterH = " + adapterH.toString());
        holder.recyclerView.setLayoutManager(
                new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        );
        holder.recyclerView.setAdapter(adapterH);
        Log.d(TAG, "setVerticalView: holder = " + holder.toString());
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof SingleVertical)
            return VERTICAL;
        else if (items.get(position) instanceof SingleHorizontal)
            return HORIZONTAL;
        return -1;
    }

    /*
     *  Declaration of ViewHolderClasses
     *
     *  Here are two types of ViewHolder
     */
    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.inner_horizontal_recyclerview);
        }
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        public VerticalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.inner_vertical_recyclerview);
        }
    }
}
