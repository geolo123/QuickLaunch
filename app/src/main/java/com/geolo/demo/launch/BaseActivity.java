package com.geolo.demo.launch;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.geolo.demo.launch.R;
import com.geolo.demo.launch.listener.OnAppInitializeListener;

/** 
 * 1. 启动后显示的第一个页面需要继承这个类（主页面或者第三方app跳转过来的）
 * 2. 因为破坏了Activity的生命周期，因此最好使用 Fragment 的方式来恢复onResume等业务所需要的生命周期*/
public abstract class BaseActivity extends AppCompatActivity {
    private final static String TAG = "BaseActivity";

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "*** BaseActivity onCreate() start 00 ***");
        setTheme(R.style.AppTheme);// 将主题切换回app的主题
        super.onCreate(savedInstanceState);
        Log.e(TAG, "*** BaseActivity onCreate() start 01 ***");
        initView();
        setAppInitListener(savedInstanceState);
        Log.e(TAG, "*** BaseActivity onCreate() end ***");
    }

    private void setAppInitListener(Bundle savedInstanceState) {
        Application application = getApplication();
        if (getApplication() != null && getApplication() instanceof GeoloApplication) {
            GeoloApplication geoloApplication = (GeoloApplication) application;
            if (geoloApplication.getInitComplete()) {
                Log.e(TAG, "BaseActivity 主动获取app启动初始化已 完成");
                todoStart(savedInstanceState);
            } else {
                geoloApplication.addAppInitializeListener(() -> {
                    Log.e(TAG, "BaseActivity 监听app启动初始化已 完成");
                    todoStart(savedInstanceState);
                });
            }
        }
    }

    /** UI初始化，有内容先显示*/
    protected abstract void initView();

    /** 初始化完成，做需要的工作 */
    protected abstract void todoStart(Bundle savedInstanceState);
}
