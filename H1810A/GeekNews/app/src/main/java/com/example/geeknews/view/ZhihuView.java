package com.example.geeknews.view;

import com.example.geeknews.base.BaseView;
import com.example.geeknews.bean.ZhiHuNewsBean;

public interface ZhihuView extends BaseView {
    void onSucceed(ZhiHuNewsBean zhiHuNewsBean);
}
