package com.beloushkin.android.learn.assigment_1_2.screens;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import com.beloushkin.android.learn.assigment_1_2.utils.FragmentsHelper;
import com.beloushkin.android.learn.assigment_1_2.utils.ToastHelper;


public class MainActivity extends AppCompatActivity {

    private final ToastHelper mToastHelper = new ToastHelper();

    private void appFinish() {
        finish();
        moveTaskToBack(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.beloushkin.android.learn.assigment_1_2.R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentsHelper.replaceFragment(this
                    ,FragmentsHelper.getMainFragment(this), com.beloushkin.android.learn.assigment_1_2.R.id.fragments_container);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.beloushkin.android.learn.assigment_1_2.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mToastHelper.showMessage(item.getTitle().toString(),this);
        int itemId = item.getItemId();
        Fragment fragment = FragmentsHelper.getMainFragment(this);
        switch (itemId) {
            case com.beloushkin.android.learn.assigment_1_2.R.id.main_menu_logout:
                mToastHelper.showMessage(item.getTitle().toString(), this);
                if (FragmentsHelper.allowAppExit(this)) {
                    appFinish();
                }
                break;
            case com.beloushkin.android.learn.assigment_1_2.R.id.main_menu_settings:
                mToastHelper.showMessage(item.getTitle().toString(), this);
                fragment = FragmentsHelper.getSettingsFragment(this);
                break;
            case com.beloushkin.android.learn.assigment_1_2.R.id.main_menu_search:
                mToastHelper.showMessage(item.getTitle().toString(), this);
                fragment = FragmentsHelper.getSearchFragment(this);
                break;
        }

        FragmentsHelper.replaceFragmentWithBack(this, fragment, com.beloushkin.android.learn.assigment_1_2.R.id.fragments_container);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (FragmentsHelper.allowAppExit(this)) {
            appFinish();
        } else {
            super.onBackPressed();
        }
    }
}

