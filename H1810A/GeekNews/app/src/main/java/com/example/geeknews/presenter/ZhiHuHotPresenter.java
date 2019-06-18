package com.example.geeknews.presenter;

import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.ZhihuHotBean;
import com.example.geeknews.model.ZhiHuHotModel;
import com.example.geeknews.view.ZhiHuHotView;

public class ZhiHuHotPresenter extends BasePresenter<ZhiHuHotModel, ZhiHuHotView> {

    public void RequestData() {
        myModel.RequestNet(new BaseCallBack<ZhihuHotBean>() {
            @Override
            public void onSucceed(ZhihuHotBean recentBean) {
                myView.onSucceed(recentBean);
            }

            @Override
            public void onField(String error) {
                myView.onField(error);
            }
        });

    }
}
