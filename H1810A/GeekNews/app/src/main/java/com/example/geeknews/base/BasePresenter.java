package com.example.geeknews.base;

public class BasePresenter <M extends BaseModel,V extends BaseView>{

    protected M myModel;
    protected V myView;

    public void attachModel(M myModel) {
        this.myModel = myModel;
    }

    public void initView(V myView) {
        this.myView = myView;
    }

    public void destory() {
        myModel.destory();
    }
}
