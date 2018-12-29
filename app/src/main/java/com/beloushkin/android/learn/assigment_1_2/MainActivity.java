package com.beloushkin.android.learn.assigment_1_2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.beloushkin.android.learn.assigment_1_2.screens.MainFragment;
import com.beloushkin.android.learn.assigment_1_2.screens.SearchFragment;
import com.beloushkin.android.learn.assigment_1_2.screens.SettingsFragment;
import com.beloushkin.android.learn.assigment_1_2.utils.FragmentsHelper;
import com.beloushkin.android.learn.assigment_1_2.utils.ToastHelper;

public class MainActivity extends AppCompatActivity {

    private final ToastHelper mToastHelper = new ToastHelper();


    private final MainFragment mainFragment = new MainFragment();
    private final SettingsFragment settingsFragment = new SettingsFragment();
    private final SearchFragment searchFragment = new SearchFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            Fragment fragment = getSupportFragmentManager().findFragmentByTag(MainFragment.FRAGMENT_TAG);
            if (fragment == null) {
                fragment = new MainFragment();
            }
            FragmentsHelper.replaceFragment(this,fragment,R.id.fragments_container);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       //mToastHelper.showMessage(item.getTitle().toString(),this);
       int itemId = item.getItemId();
       Fragment fragment;
       switch (itemId) {
           case R.id.main_menu_logout:
               fragment = getSupportFragmentManager().findFragmentByTag(MainFragment.FRAGMENT_TAG);
               if (fragment == null) {
                   fragment = new MainFragment();
               }
               FragmentsHelper.replaceFragment(this,fragment,R.id.fragments_container);
           case R.id.main_menu_settings:
               fragment = getSupportFragmentManager().findFragmentByTag(SettingsFragment.FRAGMENT_TAG);
               if (fragment == null) {
                   fragment = new SettingsFragment();
               }
               FragmentsHelper.replaceFragmentWithBack(this, fragment,R.id.fragments_container);
           case R.id.main_menu_search:
               fragment = getSupportFragmentManager().findFragmentByTag(SearchFragment.FRAGMENT_TAG);
               if (fragment == null) {
                   fragment = new SearchFragment();
               }
               FragmentsHelper.replaceFragmentWithBack(this, fragment,R.id.fragments_container);

       }

       return true;
    }
}
