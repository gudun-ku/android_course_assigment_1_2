package com.beloushkin.android.learn.assigment_1_2.screens;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import com.beloushkin.android.learn.assigment_1_2.R;


public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

        // Add visualizer preferences, defined in the XML file in res->xml->pref_visualizer
        addPreferencesFromResource(R.xml.app_pref);
    }

}
