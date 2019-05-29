package com.example.day01testa;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {


//    https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1
    String girlurl=" https://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/10/{path}")
    Observable<GirlBean> getgirl(@Path("path") int page);
}
