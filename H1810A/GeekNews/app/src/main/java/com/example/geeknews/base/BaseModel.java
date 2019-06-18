package com.example.geeknews.base;


import io.reactivex.disposables.CompositeDisposable;

public class BaseModel {

    protected   CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    public void destory() {
        mCompositeDisposable.clear();
    }
}
