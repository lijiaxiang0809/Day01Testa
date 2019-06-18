package com.example.geeknews.presenter;

import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.WechatBean;
import com.example.geeknews.model.WechatModel;
import com.example.geeknews.view.WechatView;

import java.util.List;

public class WechatPresenter extends BasePresenter<WechatModel, WechatView> {


    public void RequestData(String key, int num, int page) {
        myModel.RequestNet(key, num, page, new BaseCallBack<List<WechatBean.NewslistBean>>() {
            @Override
            public void onSucceed(List<WechatBean.NewslistBean> newslistBeans) {
                myView.onSucceed(newslistBeans);
            }

            @Override
            public void onField(String error) {
                myView.onField(error);
            }
        });
    }
}
