package com.beloushkin.android.learn.assigment_1_2.screens;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beloushkin.android.learn.assigment_1_2.R;


public  class SettingsFragment extends PreferenceFragmentCompat {

    public static final String FRAGMENT_TAG = "my_settings_fragment";

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_settings, container, false);
        return view;
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

    }

}
