package com.geolo.demo.launch;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.geolo.demo.launch.R;
import com.geolo.demo.launch.listener.OnAppInitializeListener;

public class BaseActivity extends AppCompatActivity {
    private final static String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);// 将主题切换回app的主题
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAppInitListener();
    }

    private void setAppInitListener() {
        Application application = getApplication();
        if (getApplication() != null && getApplication() instanceof GeoloApplication) {
            GeoloApplication geoloApplication = (GeoloApplication) application;
            if (geoloApplication.getInitComplete()) {
                Log.e(TAG, "BaseActivity 主动获取app启动初始化已 完成");
                todoStart();
            } else {
                geoloApplication.addAppInitializeListener(() -> {
                    Log.e(TAG, "BaseActivity 监听app启动初始化已 完成");
                    todoStart();
                });
            }
        }
    }

    /** 初始化完成，做需要的工作 */
    private void todoStart() {
        Log.e(TAG, "初始化完成，做需要的工作");
    }
}
