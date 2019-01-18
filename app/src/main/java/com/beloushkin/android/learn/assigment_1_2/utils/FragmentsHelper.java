package com.beloushkin.android.learn.assigment_1_2.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.beloushkin.android.learn.assigment_1_2.screens.MainFragment;
import com.beloushkin.android.learn.assigment_1_2.screens.SearchFragment;
import com.beloushkin.android.learn.assigment_1_2.screens.SettingsFragment;

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
                .addToBackStack(fragment.getTag())
                .commit();

    }

    public static Fragment getMainFragment(FragmentActivity fragmentActivity) {
        Fragment fragment = fragmentActivity
                .getSupportFragmentManager().findFragmentByTag(MainFragment.FRAGMENT_TAG);
        if (fragment == null) {
            fragment = new MainFragment();
        }
        return fragment;
    }

    public static Fragment getSettingsFragment(FragmentActivity fragmentActivity) {
        Fragment fragment = fragmentActivity
                .getSupportFragmentManager().findFragmentByTag(SettingsFragment.FRAGMENT_TAG);
        if (fragment == null) {
            fragment = new SettingsFragment();
        }
        return fragment;
    }

    public static Fragment getSearchFragment(FragmentActivity fragmentActivity) {
        Fragment fragment = fragmentActivity
                .getSupportFragmentManager().findFragmentByTag(SearchFragment.FRAGMENT_TAG);
        if (fragment == null) {
            fragment = new SearchFragment();
        }
        return fragment;
    }

    public static boolean allowAppExit (FragmentActivity fragmentActivity) {
        FragmentManager fragmentManager =
                fragmentActivity.getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
