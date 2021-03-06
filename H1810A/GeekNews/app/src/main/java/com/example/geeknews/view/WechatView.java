package com.example.geeknews.view;

import com.example.geeknews.base.BaseView;
import com.example.geeknews.bean.WechatBean;

import java.util.List;

public interface WechatView extends BaseView {
    void onField(String error);

    void onSucceed(List<WechatBean.NewslistBean> newslistBeans);
}
