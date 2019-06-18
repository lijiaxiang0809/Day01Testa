package com.example.geeknews.model;

import com.example.geeknews.api.WechatService;
import com.example.geeknews.base.BaseCallBack;
import com.example.geeknews.base.BaseModel;
import com.example.geeknews.bean.WechatBean;
import com.example.geeknews.net.BaseObserver;
import com.example.geeknews.net.HttpsUtils;
import com.example.geeknews.net.RxUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class WechatModel extends BaseModel {
    public void RequestNet(String key, int num, int page, final BaseCallBack<List<WechatBean.NewslistBean>> baseCallBack) {
        WechatService netData = HttpsUtils.getInsence()
                .getNetData(WechatService.bUrl, WechatService.class);
        netData.getWechatData(key, num, page).
                compose(RxUtils.<WechatBean>rxObserableSchedulerHelper())
                .subscribe(new Observer<WechatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WechatBean wechatBean) {
                        List<WechatBean.NewslistBean> newslist = wechatBean.getNewslist();
                        baseCallBack.onSucceed(newslist);
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
