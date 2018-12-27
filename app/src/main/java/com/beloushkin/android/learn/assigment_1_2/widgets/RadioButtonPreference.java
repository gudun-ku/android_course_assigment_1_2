package com.beloushkin.android.learn.assigment_1_2.widgets;

import android.content.Context;
import android.support.v7.preference.CheckBoxPreference;
import android.util.AttributeSet;

import com.beloushkin.android.learn.assigment_1_2.R;

public class RadioButtonPreference extends CheckBoxPreference {

    public RadioButtonPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setWidgetLayoutResource(R.layout.preference_radiobutton);
    }

    public RadioButtonPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWidgetLayoutResource(R.layout.preference_radiobutton);
    }

    public RadioButtonPreference(Context context) {
        this(context, null);
    }

    @Override
    public void onClick() {
        if (this.isChecked()) {
            return;
        }
        super.onClick();
    }
}