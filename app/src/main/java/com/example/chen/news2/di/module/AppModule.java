package com.example.chen.news2.di.module;

import com.example.chen.news2.app.App;
import com.example.chen.news2.di.ContextLife;
import com.example.chen.news2.model.db.RealmHelper;
import com.example.chen.news2.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chen on 2017/7/23.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }

    @Provides
    @Singleton
    RealmHelper provideRealmHelper() {
        return new RealmHelper(application);
    }
}