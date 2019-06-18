package com.example.geeknews.model;

import com.example.geeknews.api.ZhiHuService;
import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.bean.ZhiHuSpecialBean;
import com.example.geeknews.net.BaseObserver;
import com.example.geeknews.net.HttpsUtils;
import com.example.geeknews.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ZhiHuSpeciaModel extends BaseModel {
    public void RequestNetData(final BaseCallBack<ZhiHuSpecialBean> baseCallBack) {
        Observable<ZhiHuSpecialBean> getspecial = HttpsUtils.getInsence().getNetData(ZhiHuService.ZhiHupath, ZhiHuService.class).getspecial();
        getspecial.compose(RxUtils.<ZhiHuSpecialBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ZhiHuSpecialBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ZhiHuSpecialBean zhiHuSpecialBean) {
                        baseCallBack.onSucceed(zhiHuSpecialBean);
                    }
                });
    }
}
