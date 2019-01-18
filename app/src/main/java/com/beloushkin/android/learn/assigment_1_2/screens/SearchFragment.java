package com.beloushkin.android.learn.assigment_1_2.screens;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.beloushkin.android.learn.assigment_1_2.R;
import com.beloushkin.android.learn.assigment_1_2.utils.ToastHelper;

public class SearchFragment extends Fragment
        implements Button.OnClickListener  {

    public static final String FRAGMENT_TAG = "my_search_fragment";

    private static final ToastHelper mToastHelper = new ToastHelper();

    private TextView mSearchEngineTxt;
    private Button mSearchButton;
    private EditText mSearchQueryEt;
    private String strSearchUrl, strSearchSummary;



    public SearchFragment() {
        // Required empty public constructor
    }

    private void setSearchEngineFromPreferences(SharedPreferences sharedPreferences) {
        strSearchUrl = sharedPreferences.getString(getString(R.string.pref_search_engine_option_key),
                getString(R.string.pref_search_engine_option_default));

        strSearchSummary = getPreferenceLabelForValue(strSearchUrl);
    }

    private String getPreferenceLabelForValue(String strVal) {

        CharSequence[] entryValues = getResources().getStringArray( R.array.array_search_engine_values);
        CharSequence[] entryLabels = getResources().getStringArray( R.array.array_search_engine_labels);
        int pIdx = 0;
        for(int i = 0; i < entryValues.length; i++)
        {
            if (strVal.equals(entryValues[i])) {
                pIdx = i;
                break;
            }
        }
        return entryLabels[pIdx].toString();

    }

    @Override
    public void onClick(View view) {
        String strToSearch = mSearchQueryEt.getText().toString();
        if (TextUtils.isEmpty(strToSearch)) {
            mToastHelper.showMessage(getString(R.string.msg_empty_query),getContext());
            return;
        }
        Uri uri = Uri.parse(strSearchUrl + strToSearch);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_search, container, false);

        setSearchEngineFromPreferences(PreferenceManager.getDefaultSharedPreferences(getContext()));
        mSearchEngineTxt = view.findViewById(R.id.tv_search_engine);
        mSearchEngineTxt.setText(getString(R.string.pref_search_engine_option_label) + " " +
               strSearchSummary );

        mSearchQueryEt = view.findViewById(R.id.ed_query_txt);
        mSearchButton = view.findViewById(R.id.btn_search);
        mSearchButton.setOnClickListener(this);

        return view;
    }


}
