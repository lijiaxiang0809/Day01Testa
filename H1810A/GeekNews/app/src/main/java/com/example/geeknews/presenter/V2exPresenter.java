package com.example.geeknews.presenter;

import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.V2exNodeNaviBean;
import com.example.geeknews.model.V2exModel;
import com.example.geeknews.view.V2eView;

import java.util.List;

public class V2exPresenter extends BasePresenter<V2exModel, V2eView> {


    public void RequestData() {
        myModel.RequestNet(new BaseCallBack<List<V2exNodeNaviBean.DataBean>>() {
            @Override
            public void onSucceed(List<V2exNodeNaviBean.DataBean> articlesBeans) {
                myView.onSucceed(articlesBeans);
            }

            @Override
            public void onField(String error) {
                myView.onField(error);
            }
        });
    }
}
