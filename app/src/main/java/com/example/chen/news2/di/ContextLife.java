package com.example.chen.news2.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by chen on 2017/7/23.
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ContextLife {
    String value() default "Application";
}
