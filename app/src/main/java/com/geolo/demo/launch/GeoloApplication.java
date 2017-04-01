package com.geolo.demo.launch;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.geolo.demo.launch.listener.OnAppInitializeListener;
import com.geolo.demo.launch.service.LaunchService;
import com.geolo.demo.launch.utils.AppTools;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

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
    /** 是否初始化开始 */
    private boolean isInitStart = false;
    /** 是否初始化完成 */
    private boolean isInitComplete = false;
    /** 初始化的监听事件，不做remove处理，不可能新增非常多的监听的，监听完成后清空此对象 */
    private List<WeakReference<OnAppInitializeListener>> appInitListenerList = new ArrayList<>();

    public void addAppInitializeListener(OnAppInitializeListener listener) {
        if (isInitStart && appInitListenerList != null && listener != null) {
            appInitListenerList.add(new WeakReference<>(listener));
        }
    }

    public List<WeakReference<OnAppInitializeListener>> getAppInitializeListenerList() {
        return appInitListenerList;
    }

    public void cleanAppInitializeListenerList() {
        if (appInitListenerList != null) {
            appInitListenerList.clear();
        }
        appInitListenerList = null;
    }

    /** 设置初始化完成 */
    public void setInitComplete() {
        Log.e(TAG, "*** 设置初始化完成 setInitComplete   ***");
        isInitStart = false;
        isInitComplete = true;
    }

    /** 获取初始化是否完成 */
    public boolean getInitComplete() {
        return isInitComplete;
    }

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
            Log.e(TAG, "*** onCreate() 远程的Service初始化 ***");
            return;// 如果app启用了远程的service，此application:onCreate会被调用2次
        }
        Log.e(TAG, "*** onCreate() local的Service初始化 ***");
        isInitStart = true;
        isInitComplete = false;
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
