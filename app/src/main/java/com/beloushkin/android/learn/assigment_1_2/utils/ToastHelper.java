package com.beloushkin.android.learn.assigment_1_2.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastHelper {

    private Toast mToast;

    public void showMessage(String msg, Context context) {
        if (mToast != null) {
            mToast.cancel();
        }

        mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        mToast.show();
    }
}
