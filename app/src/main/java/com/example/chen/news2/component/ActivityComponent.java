package com.example.chen.news2.component;

import android.app.Activity;

import com.example.chen.news2.di.ActivityScope;
import com.example.chen.news2.di.component.AppComponent;
import com.example.chen.news2.di.module.ActivityModule;
import com.example.chen.news2.ui.main.WelcomeActivity;
import com.example.chen.news2.ui.main.activity.MainActivity;
import com.example.chen.news2.ui.zhihu.activity.SectionActivity;
import com.example.chen.news2.ui.zhihu.activity.ThemeActivity;
import com.example.chen.news2.ui.zhihu.activity.ZhihuDetailActivity;

import dagger.Component;

/**
 * Created by chen on 2017/7/21.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);

    void inject(ZhihuDetailActivity zhihuDetailActivity);

    void inject(ThemeActivity themeActivity);

    void inject(SectionActivity sectionActivity);
}
