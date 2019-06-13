package com.example.lijiaxiang.contract;

import com.example.lijiaxiang.RootBean;

import java.util.List;

public interface IContract {
    interface Model {
        void RequestData(CallBack callBack);
    }

    interface View {
        void onSucceed(List<RootBean> succeed);
        void onField(String error);
    }

    interface Presenter {
        void RequestData();
    }
    interface CallBack{
        void onSucceed(List<RootBean> succeed);
        void onField(String error);
    }
}
