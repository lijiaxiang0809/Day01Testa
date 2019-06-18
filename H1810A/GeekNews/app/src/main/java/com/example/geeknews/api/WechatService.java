package com.example.geeknews.api;

import com.example.geeknews.bean.WechatBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WechatService {

//    http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1)

    public String bUrl = "http://api.tianapi.com/";
    //key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1
    @GET("wxnew/?")
    Observable<WechatBean> getWechatData(@Query("key") String key, @Query("num") int num, @Query("page") int page);

    @GET("wxnew/?")
    Observable<WechatBean> getSearchData(@Query("key") String key, @Query("num") int num, @Query("page") int page, @Query("word") String word);
}
