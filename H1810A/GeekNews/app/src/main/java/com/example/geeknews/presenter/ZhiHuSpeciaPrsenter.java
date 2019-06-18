package com.example.geeknews.presenter;

import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.ZhiHuSpecialBean;
import com.example.geeknews.model.ZhiHuSpeciaModel;
import com.example.geeknews.view.ZhiHuSpeciaView;

public class ZhiHuSpeciaPrsenter extends BasePresenter<ZhiHuSpeciaModel,ZhiHuSpeciaView> {


    public void getRequestData() {
        myModel.RequestNetData(new BaseCallBack<ZhiHuSpecialBean>() {
            @Override
            public void onSucceed(ZhiHuSpecialBean zhiHuSpecialBean) {
                myView.onSucceed(zhiHuSpecialBean);
            }

            @Override
            public void onField(String error) {

            }
        });
    }
}
