package com.beloushkin.android.learn.assigment_1_2.preferences;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.beloushkin.android.learn.assigment_1_2.R;

public class PreferenceRadioGroup
        extends android.support.v7.preference.PreferenceGroup {

    private CharSequence[] entries;
    private CharSequence[] entryValues;
    private CharSequence selectedValue;
    private CharSequence summary;

    public PreferenceRadioGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    public PreferenceRadioGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public PreferenceRadioGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PreferenceRadioGroup(Context context) {
        this(context, null);
    }


    public void init(Context context, AttributeSet attributeSet, int defStyleAttr, int defStyleRes) {
        setLayoutResource(R.layout.preference_radiogroup);
        // Attributes
        int[] attributes = {android.R.attr.entries, android.R.attr.entryValues};
        TypedArray a = context.obtainStyledAttributes(attributeSet, attributes, defStyleAttr, defStyleRes);
        entries = a.getTextArray(R.styleable.ListPreference_android_entries);
        entryValues = a.getTextArray(R.styleable.ListPreference_android_entryValues);
        a.recycle();
        if (entries == null || entryValues == null) {
            throw new IllegalStateException("No empty entries or entryValues allowed!");
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        RadioGroup radioGroup = (RadioGroup) holder.findViewById(R.id.widget_radio_group);
        if (radioGroup != null) {
            addRadioButtons(radioGroup);
            setRadioGroupListener(radioGroup, holder);
        }
    }

    public String getSelected() {
        return (selectedValue == null) ? "" : selectedValue.toString();
    }

    private void addRadioButtons(RadioGroup radioGroup) {

        // Get the index of preference that was selected prior, default to zero otherwise
        int indexOfSavedPreference = 0;
        // Find length of entries, then build an equal length on based on it
        int lengthOfEntries = entries.length;
        String savedValue = getPersistedString("");
        radioGroup.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        // Create the layout params for radio buttons
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.MATCH_PARENT,
                RadioGroup.LayoutParams.WRAP_CONTENT,
                1f);
        layoutParams.setMargins(50,20,50,20);



        for (int i = 0; i < lengthOfEntries; i++) {
            CharSequence value = entries[i];
            RadioButton radioButton = (RadioButton) inflater.inflate(R.layout.preference_radiobutton, null);


            radioButton.setText(value);
            radioButton.setId(i + 1);
            if (value.equals(savedValue)) {
                indexOfSavedPreference = i;
            }
            radioGroup.addView(radioButton, layoutParams);
        }
        ((RadioButton) radioGroup.getChildAt(indexOfSavedPreference)).setChecked(true);
    }


    private void setRadioGroupListener(RadioGroup radioGroup, final PreferenceViewHolder holder) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selected = (RadioButton) holder.findViewById(checkedId);
                selectedValue = selected.getText();
                persistString(selectedValue.toString());
            }
        });
    }

    @Override
    public void setSummary(CharSequence summary) {
        this.summary = summary;
    }

    @Override
    public CharSequence getSummary() {
        return summary;
    }
}