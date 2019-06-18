package com.example.geeknews.base;

import android.app.Application;

public class BaseApplication extends Application {

    protected static BaseApplication sBaseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApplication = this;
    }

    public static BaseApplication getApplication() {
        return sBaseApplication;
    }
}
