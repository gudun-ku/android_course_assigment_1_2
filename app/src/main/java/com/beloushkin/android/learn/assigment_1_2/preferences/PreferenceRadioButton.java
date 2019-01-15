package com.beloushkin.android.learn.assigment_1_2.preferences;


import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;

import com.beloushkin.android.learn.assigment_1_2.R;

/**
 * Radio Button preference
 */
public class PreferenceRadioButton extends Preference {

    public interface OnRadioButtonClickedListener {
        /**
         * Called when this preference needs to be saved its state.
         *
         * @param preference This preference.
         */
        void onRadioButtonClicked(PreferenceRadioButton preference);
    }

    private boolean mIsSelected;
    private RadioButton mRadioButton;
    private OnRadioButtonClickedListener mListener;
    private final View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            callListenerOnRadioButtonClicked();
        }
    };

    public PreferenceRadioButton(final Context context) {
        this(context, null);
    }

    public PreferenceRadioButton(final Context context, final AttributeSet attrs) {
        this(context, attrs, android.R.attr.preferenceStyle);
    }

    public PreferenceRadioButton(final Context context, final AttributeSet attrs,
                                 final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWidgetLayoutResource(R.layout.preference_radiobutton);
    }

    public void setOnRadioButtonClickedListener(final OnRadioButtonClickedListener listener) {
        mListener = listener;
    }

    void callListenerOnRadioButtonClicked() {
        if (mListener != null) {
            mListener.onRadioButtonClicked(this);
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        mRadioButton = holder.itemView.findViewById(R.id.radio_button);
        mRadioButton.setChecked(mIsSelected);
        mRadioButton.setOnClickListener(mClickListener);
        holder.itemView.setOnClickListener(mClickListener);
    }

    public void setSelected(final boolean selected) {
        if (selected == mIsSelected) {
            return;
        }
        mIsSelected = selected;
        if (mRadioButton != null) {
            mRadioButton.setChecked(selected);
        }
        notifyChanged();
    }

    public boolean isSelected() {
        return mIsSelected;
    }
}