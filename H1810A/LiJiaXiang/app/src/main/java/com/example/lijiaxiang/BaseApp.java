package com.example.lijiaxiang;

import android.app.Application;

import com.example.lijiaxiang.db.DaoMaster;
import com.example.lijiaxiang.db.DaoSession;

public class BaseApp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "gasdasd.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
