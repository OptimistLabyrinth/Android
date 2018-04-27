package com.example.yks93.introandroiddemojava;

import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

public class ExerciseActivityMapper {

    private static ExerciseActivityMapper singletone;
    private HashMap<String, Class<? extends AppCompatActivity>> exerciseClassMap;

    public ExerciseActivityMapper() {
        defineExerciseMappings();
    }

    private void defineExerciseMappings() {
        exerciseClassMap = new HashMap<String, Class<? extends AppCompatActivity>>();
        // Chapter 1 : App Fundamentals
        exerciseClassMap.put("chap2ex1", BasicTextViewActivity.class);
        // Chapter 2 : User Interface
        // Chapter 3 : View Controls
        // Chapter 4 : User Interactions
        exerciseClassMap.put("chap4ex1", BasicClickHandlers.class);
        // Chapter 5 : User Flows
        exerciseClassMap.put("chap5ex4", ActionBarMenuActivity.class);
        // Chapter 6 : Networking
        exerciseClassMap.put("chap6ex1", BasicImageDownloadActivity.class);
        exerciseClassMap.put("chap6ex2", AsyncTaskPerformActivity.class);
        // Chapter 7 : Advanced Views
        // Chapter 8 : Preferences
        // Chapter 9 : ContentProviders
        // Chpater 10 : Publishing

    }

    public static ExerciseActivityMapper getSingleton() {
        if (singletone == null)
            singletone = new ExerciseActivityMapper();
        return singletone;
    }

    public static Class<? extends AppCompatActivity> getExerciseClass(String exercisedId) {
        return getSingleton().exerciseClassMap.get(exercisedId);
    }
}
