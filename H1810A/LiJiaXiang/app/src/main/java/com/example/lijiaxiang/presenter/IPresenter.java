package com.example.lijiaxiang.presenter;

import com.example.lijiaxiang.RootBean;
import com.example.lijiaxiang.contract.IContract;
import com.example.lijiaxiang.model.IModel;

import java.util.List;

public class IPresenter implements IContract.Presenter {
    IModel mIModel;
    IContract.View mView;

    public IPresenter(IContract.View view) {
        mIModel = new IModel();
        mView = view;
    }

    @Override
    public void RequestData() {
        mIModel.RequestData(new IContract.CallBack() {
            @Override
            public void onSucceed(List<RootBean> succeed) {
                mView.onSucceed(succeed);
            }

            @Override
            public void onField(String error) {
                mView.onField(error);
            }
        });
    }
}
