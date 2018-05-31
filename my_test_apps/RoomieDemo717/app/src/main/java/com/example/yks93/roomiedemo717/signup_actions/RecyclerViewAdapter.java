package com.example.yks93.roomiedemo717.signup_actions;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.yks93.roomiedemo717.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/*
 *  Depreciated
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final String TAG = "RecyclerViewAdapter";

    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "getItemViewType: ");
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: ");
            ButterKnife.bind(itemView);
        }
    }

}
