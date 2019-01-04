package com.beloushkin.android.learn.assigment_1_2.screens;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.View;
import android.widget.RadioGroup;

import com.beloushkin.android.learn.assigment_1_2.R;
import com.beloushkin.android.learn.assigment_1_2.preferences.PreferenceRadioGroup;
import com.beloushkin.android.learn.assigment_1_2.preferences.RadioButtonPreference;

import java.util.ArrayList;

public  class SettingsFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener {

    public static final String FRAGMENT_TAG = "my_settings_fragment";
    private final ArrayList<RadioButtonPreference> listViewMode = new ArrayList<>();


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Preference.OnPreferenceChangeListener listener = (Preference.OnPreferenceChangeListener) getActivity();
        listener.onPreferenceChange(preference, newValue);
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.app_pref);

        PreferenceRadioGroup p = (PreferenceRadioGroup ) getPreferenceManager()
                .findPreference(getString(R.string.pref_search_engine_option_key));

        p.setOnPreferenceChangeListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

        //final PreferenceScreen screen = getPreferenceScreen();
        //final int count = screen.getPreferenceCount();
        /*
        for (int index = 0; index < count; index++) {
            final Preference preference = screen.getPreference(index);
            if (preference instanceof RadioButtonPreference) {
                final RadioButtonPreference pref = (RadioButtonPreference) preference;
                final boolean selected = ( mSelectedSearchEngine == pref.getKey());
                pref.setSelected(selected);
                pref.setOnRadioButtonClickedListener(this);
            }
        }
        */
    }

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        //View view =  inflater.inflate(R.layout.fragment_settings, container, false);
        //return view;
    }
    */


}
