package com.example.chen.news2.di.component;

import com.example.chen.news2.app.App;
import com.example.chen.news2.di.ContextLife;
import com.example.chen.news2.di.module.AppModule;
import com.example.chen.news2.model.db.RealmHelper;
import com.example.chen.news2.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chen on 2017/7/22.
 */



    @Singleton
    @Component(modules = AppModule.class)
    public interface AppComponent {

        @ContextLife("Application")
        App getContext();  // 提供App的Context

        RetrofitHelper retrofitHelper();  //提供http的帮助类

        RealmHelper realmHelper();    //提供数据库帮助类


}
