package com.example.chen.news2.ui.main.activity;

import android.support.annotation.NonNull;

import com.example.chen.news2.base.BaseActivity;
import com.example.chen.news2.presenter.MainPresenter;
import com.example.chen.news2.presenter.contract.MainContract;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, EasyPermissions.PermissionCallbacks{
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }
}

