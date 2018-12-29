package com.beloushkin.android.learn.assigment_1_2.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

public class FragmentsHelper {

    public static void replaceFragment(FragmentActivity fragmentActivity
            , Fragment fragment, int containerId) {
                 fragmentActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();

    }

    public static void replaceFragmentWithBack(FragmentActivity fragmentActivity
            , Fragment fragment, int containerId) {
                 fragmentActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(null)
                .commit();

    }

}
