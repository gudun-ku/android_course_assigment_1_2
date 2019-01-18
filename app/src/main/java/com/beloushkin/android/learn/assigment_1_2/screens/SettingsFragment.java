package com.beloushkin.android.learn.assigment_1_2.screens;


import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.View;

import com.beloushkin.android.learn.assigment_1_2.R;
import com.beloushkin.android.learn.assigment_1_2.preferences.PreferenceRadioButton;
import com.beloushkin.android.learn.assigment_1_2.preferences.PreferenceRadioGroup;

import java.util.ArrayList;

public  class SettingsFragment extends PreferenceFragmentCompat implements  OnSharedPreferenceChangeListener {

    public static final String FRAGMENT_TAG = "my_settings_fragment";
    private final ArrayList<PreferenceRadioButton> listViewMode = new ArrayList<>();


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.app_pref);
        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        // Figure out which preference was changed
        Preference preference = findPreference(key);
        if (null != preference) {
            // Updates the summary for the preference
            if (preference instanceof PreferenceRadioGroup) {
                String label =
                        ((PreferenceRadioGroup) preference).getSelectedLabel();
                if (label.equals("")) label = getString(R.string.pref_search_engine_default_label);
                setPreferenceSummary(preference, label);
            }
        }
    }

    private void setPreferenceSummary(Preference preference, String value) {
        if (preference instanceof PreferenceRadioGroup) {
            PreferenceRadioGroup rgPreference = (PreferenceRadioGroup) preference;
            rgPreference.setSummary(rgPreference.getSelectedLabel());
        }
    }

}
