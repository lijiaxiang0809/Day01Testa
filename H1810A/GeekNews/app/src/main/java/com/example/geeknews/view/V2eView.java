package com.example.geeknews.view;

import com.example.geeknews.base.BaseView;
import com.example.geeknews.bean.V2exNodeNaviBean;

import java.util.List;

public interface V2eView extends BaseView {
    void onField(String error);

    void onSucceed(List<V2exNodeNaviBean.DataBean> articlesBeans);
}
