package com.example.geeknews.utils;

import android.os.Environment;


import com.example.geeknews.base.BaseApplication;

import java.io.File;

/**
 * Created by $lzj on 2019/5/5.
 */
public interface AppConstants {

    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "code" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApplication.getApplication().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";

}
