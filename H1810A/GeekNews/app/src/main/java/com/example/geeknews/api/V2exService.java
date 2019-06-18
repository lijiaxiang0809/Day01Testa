package com.example.geeknews.api;

import com.example.geeknews.bean.V2exNodeNaviBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface V2exService {

//    https://www.wanandroid.com/navi/json

    String apipath=" https://www.wanandroid.com/";
    @GET("navi/json")
    Observable<V2exNodeNaviBean> getapi();
}
