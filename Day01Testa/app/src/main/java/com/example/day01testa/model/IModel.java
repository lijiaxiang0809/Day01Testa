package com.example.day01testa.model;

import com.example.day01testa.ApiService;
import com.example.day01testa.GirlBean;
import com.example.day01testa.contract.IContract;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class IModel implements IContract.Model {
    @Override
    public void RequestNet(int page, final IContract.CallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.girlurl)
                .build();
        build.create(ApiService.class)
                .getgirl(page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GirlBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GirlBean girlBean) {
                        List<GirlBean.ResultsBean> results = girlBean.getResults();
                        callBack.RequestSucceed(results);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.RequestField(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
