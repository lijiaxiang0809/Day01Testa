package com.example.day01testa.presenter;

import android.util.Log;

import com.example.day01testa.GirlBean;
import com.example.day01testa.contract.IContract;
import com.example.day01testa.model.IModel;

import java.util.List;

public class IPresenter implements IContract.Presenter {
    IContract.View mView;
    private final IModel mIModel;

    public IPresenter(IContract.View view) {
        mView = view;
        mIModel = new IModel();
    }

    @Override
    public void RequestData(int page) {
        mIModel.RequestNet(page, new IContract.CallBack() {
            @Override
            public void RequestSucceed(List<GirlBean.ResultsBean> resultsBeans) {
                mView.UpDataRequestSucceed(resultsBeans);
            }

            @Override
            public void RequestField(String error) {
                mView.UpDataRequestField(error);
            }
        });
    }
}
