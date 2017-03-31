package com.geolo.demo.launch.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;

import java.util.Iterator;
import java.util.List;

/**
 * @author Created by jwb on 2017/3/31.
 */

public class AppTools {

    /**
     * 获取指定的进程id的包名
     *
     * @param context
     * @return 进程 id 对应的包名
     */
    public static String getAppName(Context context, int appid) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = context.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == appid) {
                    return info.processName;
                }
            } catch (Exception e) {
            }
        }
        return "";
    }

}
