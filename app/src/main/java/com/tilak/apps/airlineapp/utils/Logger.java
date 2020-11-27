package com.tilak.apps.airlineapp.utils;

import android.text.TextUtils;
import android.util.Log;

import com.tilak.apps.airlineapp.BuildConfig;

public class Logger {

    public static void logMessage(final String tagName, final String message) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(message)) {
            Log.d(tagName, message);
        }
    }


    public static void logError(final String tagName, final String message) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(message)) {
            Log.e(tagName, message);
        }
    }
}
