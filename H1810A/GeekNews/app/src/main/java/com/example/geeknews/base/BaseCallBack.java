package com.example.geeknews.base;

public interface BaseCallBack<T> {
    void onSucceed(T t);
    void onField(String error);
}
