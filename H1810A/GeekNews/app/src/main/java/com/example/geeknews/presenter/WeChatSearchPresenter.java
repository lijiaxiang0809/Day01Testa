package com.example.geeknews.presenter;

import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BasePresenter;
import com.example.geeknews.bean.WechatBean;
import com.example.geeknews.model.WeChatSearchModel;
import com.example.geeknews.view.WeChatSearchView;

import java.util.List;

public class WeChatSearchPresenter extends BasePresenter<WeChatSearchModel, WeChatSearchView> {


    public void RequestData(String key, int num, int page, String query) {
        myModel.RequestNet(key, num, page, query, new BaseCallBack<List<WechatBean.NewslistBean>>() {
            @Override
            public void onSucceed(List<WechatBean.NewslistBean> newslistBean) {
                myView.onSucceed(newslistBean);
            }

            @Override
            public void onField(String error) {
                myView.onField(error);
            }
        });
    }
}
