package com.example.geeknews.utils;

import android.util.Log;

import com.example.geeknews.BuildConfig;

/**
 * Created by $lzj on 2019/5/5.
 */
public class Logger {

    public static void logD(String tag,String msg){
        if (BuildConfig.DEBUG){
            Log.d(tag, "logD: "+msg);
        }
    }
}
