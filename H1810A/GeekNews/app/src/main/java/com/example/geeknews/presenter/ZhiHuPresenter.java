package com.example.geeknews.presenter;


import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.base.BaseView;
import com.example.geeknews.bean.ZhiHuNewsBean;
import com.example.geeknews.model.ZhiHuHotModel;
import com.example.geeknews.model.ZhiHuModel;
import com.example.geeknews.view.ZhiHuHotView;
import com.example.geeknews.view.ZhihuView;

public class ZhiHuPresenter extends BasePresenter<ZhiHuModel, ZhihuView> {


    public void RequestBannerData() {
        myModel.RequestBannerNetData(new BaseCallBack<ZhiHuNewsBean>() {
            @Override
            public void onSucceed(ZhiHuNewsBean zhiHuNewsBean) {
                myView.onSucceed(zhiHuNewsBean);
            }

            @Override
            public void onField(String error) {

            }
        });
    }
}
