package com.example.yks93.myfragment03;

import android.os.Bundle;

public interface FragmentActionListener {

    String ACTION_KEY = "action_key";
    int ACTION_VALUE_COUNTRY_SELECTED = 1;
    String KEY_SELECTED_COUNTRY="KEY_SELECTED_COUNTRY";

    void onActionPerformed(Bundle bundle);

}
