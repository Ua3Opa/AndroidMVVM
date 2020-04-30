package com.presentation.databinding;

import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.databinding.BindingAdapter;

public class DataBindingAdapter {

    @BindingAdapter("textColor")
    public static void setTextColor(TextView textView, int color) {
        textView.setTextColor(color);
    }

}
