package com.example.geeknews.model;

import com.example.geeknews.api.V2exService;
import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.bean.V2exNodeNaviBean;
import com.example.geeknews.net.HttpsUtils;
import com.example.geeknews.net.RxUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class V2exModel extends BaseModel {
    public void RequestNet(final BaseCallBack<List<V2exNodeNaviBean.DataBean>> baseCallBack) {
        V2exService netData = HttpsUtils.getInsence()
                .getNetData(V2exService.apipath, V2exService.class);
        netData.getapi().compose(RxUtils.<V2exNodeNaviBean>rxObserableSchedulerHelper())
                .subscribe(new Observer<V2exNodeNaviBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(V2exNodeNaviBean v2exNodeNaviBean) {
                        List<V2exNodeNaviBean.DataBean> data = v2exNodeNaviBean.getData();
                        baseCallBack.onSucceed(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseCallBack.onField(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
