package com.example.geeknews.model;

import com.example.geeknews.api.ZhiHuService;
import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.bean.ZhiHuNewsBean;
import com.example.geeknews.net.BaseObserver;
import com.example.geeknews.net.HttpsUtils;
import com.example.geeknews.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ZhiHuModel extends BaseModel {
    public void RequestBannerNetData(final BaseCallBack<ZhiHuNewsBean> baseCallBack) {
        Observable<ZhiHuNewsBean> getnews = HttpsUtils.getInsence().getNetData(ZhiHuService.ZhiHupath, ZhiHuService.class).getnews();
        getnews.compose(RxUtils.<ZhiHuNewsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ZhiHuNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ZhiHuNewsBean zhiHuNewsBean) {
                        baseCallBack.onSucceed(zhiHuNewsBean);
                    }
                });
    }
}
