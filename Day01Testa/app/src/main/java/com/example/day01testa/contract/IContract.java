package com.example.day01testa.contract;

import com.example.day01testa.GirlBean;

import java.util.List;

public interface IContract {
    interface Model {
        void RequestNet(int page ,CallBack callBack);
    }

    interface View {
        void UpDataRequestSucceed(List<GirlBean.ResultsBean> resultsBeans);
        void UpDataRequestField(String error);
    }

    interface Presenter {
        void RequestData(int page);
    }

    interface CallBack {
       void RequestSucceed(List<GirlBean.ResultsBean> resultsBeans);
       void RequestField(String error);
    }
}
