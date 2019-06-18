package com.example.geeknews.model;

import com.example.geeknews.api.ZhiHuService;
import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.bean.ZhihuHotBean;
import com.example.geeknews.net.BaseObserver;
import com.example.geeknews.net.HttpsUtils;
import com.example.geeknews.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ZhiHuHotModel extends BaseModel {

    public void RequestNet(final BaseCallBack<ZhihuHotBean> baseCallBack) {
        ZhiHuService netData = HttpsUtils.getInsence().getNetData(ZhiHuService.ZhiHupath, ZhiHuService.class);
        Observable<ZhihuHotBean> gethotbean = netData.gethotbean();
        gethotbean.compose(RxUtils.<ZhihuHotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ZhihuHotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ZhihuHotBean zhihuHotBean) {
                        baseCallBack.onSucceed(zhihuHotBean);
                    }
                });
    }
}
