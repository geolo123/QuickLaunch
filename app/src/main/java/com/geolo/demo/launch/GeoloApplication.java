package com.geolo.demo.launch;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.geolo.demo.launch.service.LaunchService;
import com.geolo.demo.launch.utils.AppTools;

/**
 * <pre>
 *     1. 启动的几种类型：冷启动、热启动、温启动
 *     
 * </pre>
 * @author Created by jwb on 2017/3/31.
 * @参考文献: http://www.jianshu.com/p/c2e026d1d726
 * 
 */
public class GeoloApplication extends Application {
    private static final String TAG = "GeoloApplication";

    @Override
    protected void attachBaseContext(Context base) {
        Log.e(TAG, "*** 分包 MultiDex attachBaseContext() start ***");
        super.attachBaseContext(base);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "*** 分包 MultiDex attachBaseContext() end ***");
    }

    @Override
    public void onCreate() {
        Log.v(TAG, "*** onCreate() start ***");
        super.onCreate();
        int pid = android.os.Process.myPid();
        String processAppName = AppTools.getAppName(this, pid);
        if (processAppName == null || getBaseContext() == null || !processAppName.equalsIgnoreCase(getPackageName())) {
            Log.e("Geolo", "*** onCreate() 远程的Service初始化 ***");
            return;// 如果app启用了远程的service，此application:onCreate会被调用2次
        }
        Log.e("Geolo", "*** onCreate() local的Service初始化 ***");
        LaunchService.start(this);

        Log.v(TAG, "*** onCreate() end ***");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.v(TAG, "*** onConfigurationChanged() start ***");
        super.onConfigurationChanged(newConfig);
        Log.v(TAG, "*** onConfigurationChanged() end ***");
    }

    @Override
    public void onLowMemory() {
        Log.v(TAG, "*** onLowMemory() start ***");
        super.onLowMemory();
        Log.v(TAG, "*** onLowMemory() end ***");
    }

    @Override
    public void onTerminate() {
        Log.v(TAG, "*** onTerminate() start ***");
        super.onTerminate();
        Log.v(TAG, "*** onTerminate() end ***");
    }

    @Override
    public void onTrimMemory(int level) {
        Log.v(TAG, "*** onTrimMemory() start ***");
        super.onTrimMemory(level);
        Log.v(TAG, "*** onTrimMemory() end ***");
    }

    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }

    @Override
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.unregisterActivityLifecycleCallbacks(callback);
    }

}
