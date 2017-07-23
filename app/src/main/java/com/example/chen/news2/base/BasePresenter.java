package com.example.chen.news2.base;

/**
 * Created by chen on 2017/7/21.
 */

public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}