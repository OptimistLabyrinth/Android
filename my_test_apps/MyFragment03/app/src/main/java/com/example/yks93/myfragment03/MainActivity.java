package com.example.yks93.myfragment03;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentActionListener {

    private static final String COMMON_TAG = "OrientationChange";
    private static final String ACTIVITY_NAME = MainActivity.class.getSimpleName();

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            addCountriesFragment();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Log.i(COMMON_TAG, "Landscape");
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            Log.i(COMMON_TAG, "portrait");
    }

    private void addCountriesFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        CountriesFragment countryListFragment = new CountriesFragment();
        countryListFragment.setFragmentActionListener(this);

        fragmentTransaction.add(R.id.fragmentContainer, countryListFragment);
        fragmentTransaction.commit();
    }

    private void addCountryDescriptionFragment(Bundle bundle) {
        fragmentTransaction = fragmentManager.beginTransaction();

        CountryDescriptionFragment countryDescriptionFragment = new CountryDescriptionFragment();
        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer, countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



    @Override
    public void onActionPerformed(Bundle bundle) {
        int actionPerformed = bundle.getInt(FragmentActionListener.ACTION_KEY);
        switch (actionPerformed) {
            case FragmentActionListener.ACTION_VALUE_COUNTRY_SELECTED:
                addCountryDescriptionFragment(bundle); break;
        }
    }

}
