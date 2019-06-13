package com.example.lijiaxiang.model;

import com.example.lijiaxiang.DbUtils;
import com.example.lijiaxiang.R;
import com.example.lijiaxiang.RootBean;
import com.example.lijiaxiang.contract.IContract;

import java.util.List;

public class IModel implements IContract.Model {


    @Override
    public void RequestData(IContract.CallBack callBack) {
        List<RootBean> rootBeans = DbUtils.queryAll();
        if (rootBeans != null) {
            callBack.onSucceed(rootBeans);
        }else {
            callBack.onField("数据库无数据");
        }

    }
}
