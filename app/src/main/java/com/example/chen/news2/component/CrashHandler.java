package com.example.chen.news2.component;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.example.chen.news2.app.App;
import com.example.chen.news2.util.LogUtil;
import com.example.chen.news2.util.ToastUtil;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by chen on 2017/7/21.
 */

/*
* 全局处理异常
* */
public class CrashHandler implements Thread.UncaughtExceptionHandler{

    public static Thread.UncaughtExceptionHandler defaultHandler = null;

    private Context context = null;

    public final  String TAG = CrashHandler.class.getSimpleName();

    public CrashHandler(Context context){
        this.context = context;
    }

    /*
    * 初始化
    * 设置该CrashHander为程序的默认处理器
    * */

    public static void init(CrashHandler crashHandler){
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
    }

    /*
    * 未处理异常
    * */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.out.println(ex.toString());
        LogUtil.e(TAG,  ex.toString());
        LogUtil.e(TAG, collectCrashDeviceInfo());
        LogUtil.e(TAG,  getCrashInfo(ex));
        //调用系统错误机制
        defaultHandler.uncaughtException(thread,ex);
        ToastUtil.shortShow("抱歉,程序发生异常即将退出");
        App.getInstance().exitApp();


    }

    /*
    * 得到程序崩溃的详细信息
    * */
    private String getCrashInfo(Throwable ex) {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        ex.setStackTrace(ex.getStackTrace());
        ex.printStackTrace(printWriter);
        return result.toString();
    }

    /*
    * 收集程序崩溃的设备信息*/
    private String collectCrashDeviceInfo() {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(),PackageManager.GET_ACTIVITIES);
            String VersionName = packageInfo.versionName;
            String model = Build.MODEL;
            String androidVersion = Build.VERSION.RELEASE;
            String manufacturer = Build.MANUFACTURER;
            return VersionName + " " + model+ " " + androidVersion + " " + manufacturer;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
