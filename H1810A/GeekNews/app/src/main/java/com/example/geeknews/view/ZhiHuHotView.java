package com.example.geeknews.view;

import com.example.geeknews.base.BaseView;
import com.example.geeknews.bean.ZhihuHotBean;

public interface ZhiHuHotView extends BaseView {

    void onSucceed(ZhihuHotBean recentBean);

    void onField(String error);
}
