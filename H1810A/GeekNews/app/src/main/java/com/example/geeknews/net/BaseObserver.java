package com.example.geeknews.net;

import android.util.Log;

import com.example.geeknews.utils.ToastUtil;

import io.reactivex.Observer;

public abstract class BaseObserver<T> implements Observer<T> {

    @Override
    public void onError(Throwable e) {
        String message = e.getMessage();
        Log.i("--Main--", "onError: e="+message);
        ToastUtil.showShort("失败");
    }

    @Override
    public void onComplete() {
        Log.i("--Main--", "onComplete: ");
    }
}
