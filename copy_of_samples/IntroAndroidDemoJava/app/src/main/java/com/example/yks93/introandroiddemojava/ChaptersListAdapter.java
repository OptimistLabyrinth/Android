package com.example.yks93.introandroiddemojava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ChaptersListAdapter extends BaseExpandableListAdapter{

    Context context;
    private String[] chapters;
    private String[][] exercises;

    public ChaptersListAdapter(Context context) {
        super();
        this.context = context;
        chapters = context.getResources().getStringArray(R.array.chapters);
        exercises = new String[chapters.length][];
        int i, exerciseLength = exercises.length;
        for (i=0; i < exerciseLength; ++i) {
            int resId = context.getResources().getIdentifier("chap" + (i+1), "array", context.getPackageName());
            exercises[i] = context.getResources().getStringArray(resId);
        }
    }

    @Override
    public int getGroupCount() {
        return exercises.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return exercises[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return "Chapter " + (groupPosition + 1) + ": " + chapters[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return exercises[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public TextView getGenericView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView textView = new TextView(context);
        textView.setLayoutParams(lp);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
        textView.setPadding(60,20,20, 20);
        return textView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView textView = getGenericView();
        textView.setText(getGroup(groupPosition).toString());
        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView = getGenericView();
        textView.setPadding(60,20,20,20);
        textView.setText(getChild(groupPosition, childPosition).toString());
        return textView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    public Class<? extends AppCompatActivity> getExerciseClass(int groupPosition, int childPosition, long id) {
        String exercisedId = "chap" + (groupPosition + 1) + "ex" + (childPosition + 1);
        return ExerciseActivityMapper.getExerciseClass(exercisedId);
    }

}
