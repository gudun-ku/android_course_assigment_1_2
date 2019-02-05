package com.beloushkin.android.learn.assigment_1_2.screens;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.beloushkin.android.learn.assigment_1_2.R;

public class MainFragment extends Fragment implements ITaggedFragment {

    public static final String FRAGMENT_TAG = "my_main_fragment";

    private ImageView mImageView;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public String getFragmentTag() {
        return FRAGMENT_TAG;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mImageView = view.findViewById(R.id.image_with_logo);
        mImageView.setImageResource(R.drawable.logoscreen);
        return view;
    }

}
