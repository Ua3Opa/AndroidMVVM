package com.presentation.utils;

import android.util.Log;

import com.presentation.config.Config;

public class LogUtils {

    public static void d(String message) {
        d("", message);
    }

    public static void d(String tag, String message) {
        if (Config.environment != Config.ENVIRONMENT.DEVELOP) {
            return;
        }
        Log.d(tag, "d: " + message);
    }
}
