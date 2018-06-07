package com.example.yks93.rooommie777.searchroommate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yks93.rooommie777.R;
import com.example.yks93.rooommie777.static_storage.StaticVarMethods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecommendRoomateAdapter extends RecyclerView.Adapter<RecommendRoomateAdapter.RoommateViewHolder> {

    List<DataRoommate> dataList;

    private final String TAG = "RecommendRoomateAdapter";

    public RecommendRoomateAdapter(List<DataRoommate> dataList) {
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public RoommateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_recommend_roommate, parent, false);
        return new RoommateViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RoommateViewHolder holder, int position) {
        DataRoommate item = dataList.get(position);

        holder.name.setText(item.getName());

        holder.tv_temp.setText(R.string.age);
        holder.age.setText(holder.tv_temp.getText().toString() + ": " + item.getAge());

        holder.major.setText(item.getMajor());

        holder.phone.setText(item.getPhone());

        holder.tv_temp.setText(R.string.grade);
        holder.grade.setText(holder.tv_temp.getText().toString() + ": " + item.getGrade());

        holder.tv_temp.setText(R.string.clean);
        holder.clean.setText(holder.tv_temp.getText().toString() + ": " + item.getClean());

        holder.tv_temp.setText(R.string.yasik);
        holder.yasik.setText(item.getYasik());

        holder.character.setText(item.getCharacter());

        holder.tv_temp.setText(R.string.activity);
        holder.activity.setText(holder.tv_temp.getText().toString() + ": " +item.getActivity());

        holder.tv_temp.setText(R.string.freqDrink);
        holder.freqDrink.setText(holder.tv_temp.getText().toString() + ": " + item.getFreqDrink());

        holder.tv_temp.setText(R.string.drink);
        holder.drink.setText(holder.tv_temp.getText().toString() + ": " + item.getDrink());

        holder.smoke.setText(item.getSmoke());
    }

    @Override
    public int getItemCount() {
        return this.dataList.size();
    }

    public class RoommateViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name_reco_mate)
        TextView name;
        @BindView(R.id.tv_age_reco_mate)
        TextView age;
        @BindView(R.id.tv_major_reco_mate)
        TextView major;
        @BindView(R.id.tv_phone_reco_mate)
        TextView phone;
        @BindView(R.id.tv_grade_reco_mate)
        TextView grade;
        @BindView(R.id.tv_clean_reco_mate)
        TextView clean;
        @BindView(R.id.tv_yasik_reco_mate)
        TextView yasik;
        @BindView(R.id.tv_character_reco_mate)
        TextView character;
        @BindView(R.id.tv_activity_reco_mate)
        TextView activity;
        @BindView(R.id.tv_freq_drink_reco_mate)
        TextView freqDrink;
        @BindView(R.id.tv_drink_reco_mate)
        TextView drink;
        @BindView(R.id.tv_smoke_reco_mate)
        TextView smoke;
        @BindView(R.id.btn_more_reco_mate)
        Button btn_more;

        @BindView(R.id.tv_temp)
        TextView tv_temp;

        ArrayList<TextView> tvList = new ArrayList<>();
        private int more_or_less = StaticVarMethods.MORE;

        public RoommateViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            tvList.add(age);
            tvList.add(phone);
            tvList.add(clean);
            tvList.add(yasik);
            tvList.add(character);
            tvList.add(activity);
            tvList.add(drink);

            btn_more = (Button) itemView.findViewById(R.id.btn_more_reco_mate);

        }

        @OnClick(R.id.btn_more_reco_mate)
        void onMoreButtonClicked() {
            if (more_or_less == StaticVarMethods.MORE) {
                for (TextView tv : tvList) {
                    tv.setVisibility(View.VISIBLE);
                }
                more_or_less = StaticVarMethods.LESS;
                btn_more.setText(R.string.less);
            }
            else {
                for (TextView tv : tvList) {
                    tv.setVisibility(View.GONE);
                }
                more_or_less = StaticVarMethods.MORE;
                btn_more.setText(R.string.more);
            }
        }

    }
}

/*

            name = (TextView) itemView.findViewById(R.id.tv_name_reco_mate);
            age = (TextView) itemView.findViewById(R.id.tv_age_reco_mate);
            major = (TextView) itemView.findViewById(R.id.tv_major_reco_mate);
            phone = (TextView) itemView.findViewById(R.id.tv_phone_reco_mate);
            grade = (TextView) itemView.findViewById(R.id.tv_grade_reco_mate);
            clean = (TextView) itemView.findViewById(R.id.tv_clean_reco_mate);
            yasik = (TextView) itemView.findViewById(R.id.tv_yasik_reco_mate);
            character = (TextView) itemView.findViewById(R.id.tv_character_reco_mate);
            activity = (TextView) itemView.findViewById(R.id.tv_activity_reco_mate);
            freqDrink = (TextView) itemView.findViewById(R.id.tv_freq_drink_reco_mate);
            drink = (TextView) itemView.findViewById(R.id.tv_drink_reco_mate);
            smoke = (TextView) itemView.findViewById(R.id.tv_smoke_reco_mate);

 */
