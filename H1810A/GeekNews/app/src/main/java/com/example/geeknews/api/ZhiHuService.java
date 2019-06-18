package com.example.geeknews.api;

import com.example.geeknews.bean.ZhiHuNewsBean;
import com.example.geeknews.bean.ZhiHuSpecialBean;
import com.example.geeknews.bean.ZhihuHotBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ZhiHuService {

    String ZhiHupath = "http://news-at.zhihu.com/api/4/";

    //热门
//    http://news-at.zhihu.com/api/4/news/hot
    @GET("news/hot")
    Observable<ZhihuHotBean> gethotbean();

    //专栏
//    http://news-at.zhihu.com/api/4/sections
    @GET("sections")
    Observable<ZhiHuSpecialBean> getspecial();


    //日报
//    http://news-at.zhihu.com/api/4/news/latest
    @GET("news/latest")
    Observable<ZhiHuNewsBean> getnews();
}
