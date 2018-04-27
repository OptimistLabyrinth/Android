package com.example.yks93.myfragment03;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CountriesFragment extends Fragment {

    private static final String COMMON_TAG = "OrientationChange";
    private static final String ACTIVITY_NAME = CountriesFragment.class.getSimpleName();

    View rootView;
    ListView listViewCountries;
    ArrayAdapter<String> countryNamesAdapter;
    Context context;
    String[] countries;

    FragmentActionListener fragmentActionListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_countries, container, false);
        initUI();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.app_name) + " -> Select Country");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(COMMON_TAG, "CountriesFragment onSaveInstanceState");
    }

    public void setFragmentActionListener(FragmentActionListener fragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener;
    }

    private void initUI() {
        context = getContext();
        countries = getResources().getStringArray(R.array.countries);
        listViewCountries = (ListView) rootView.findViewById(R.id.listViewCountries);
        countryNamesAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, countries);
        listViewCountries.setAdapter(countryNamesAdapter);

        listViewCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (fragmentActionListener != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(FragmentActionListener.ACTION_KEY, FragmentActionListener.ACTION_VALUE_COUNTRY_SELECTED);
                    bundle.putString(FragmentActionListener.KEY_SELECTED_COUNTRY, countries[i]);
                    fragmentActionListener.onActionPerformed(bundle);
                }
            }
        });
    }



}
