package com.example.geeknews.base;

public abstract class BaseMvpFragmetn<P extends BasePresenter,M extends BaseModel, V extends BaseView> extends BaseFragment {

    protected P myPresenter;

    @Override
    protected void initMvp() {
        myPresenter=initMvpPresenter();
        if (myPresenter!=null){
            myPresenter.attachModel(initMvpModel());
            myPresenter.initView(initMvpView());
        }
    }

    protected abstract V initMvpView();

    protected abstract M initMvpModel();

    protected abstract P initMvpPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        myPresenter.destory();
    }
}
