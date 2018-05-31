package com.example.yks93.rooommie777.searchroommate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yks93.rooommie777.R;

import java.util.List;

public class SearchRoommateAdapter extends RecyclerView.Adapter<SearchRoommateAdapter.RoommateViewHolder> {

    List<RoommateItem> dataList;

    private final String TAG = "SearchRoommateAdapter";

    public SearchRoommateAdapter(List<RoommateItem> dataList) {
        Log.d(TAG, "SearchRoommateAdapter: ");
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RoommateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder_roommate, parent, false);
        return new RoommateViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RoommateViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        RoommateItem item = dataList.get(position);
        holder.name.setText(item.getName());
        holder.stud_id.setText("("+ item.getStud_id() + ")");
        holder.gender.setText(item.getGender());
        holder.phone.setText(item.getPhone());
        holder.email.setText(item.getEmail());
        holder.major.setText(item.getMajor());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + this.dataList.size());
        return this.dataList.size();
    }

    public class RoommateViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView stud_id;
        TextView gender;
        TextView phone;
        TextView email;
        TextView major;

        public RoommateViewHolder(View itemView) {
            super(itemView);

            Log.d(TAG, "RoommateViewHolder: ");

            name = (TextView) itemView.findViewById(R.id.textview_name_roommate);
            stud_id = (TextView) itemView.findViewById(R.id.textview_stud_id_roommate);
            gender = (TextView) itemView.findViewById(R.id.textview_gender_roommate);
            phone = (TextView) itemView.findViewById(R.id.textview_phone_roommate);
            email = (TextView) itemView.findViewById(R.id.textview_email_roommate);
            major = (TextView) itemView.findViewById(R.id.textview_major_roommate);
        }




    }

}
