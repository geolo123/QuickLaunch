package com.geolo.demo.launch.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author Created by jwb on 2017/3/31.
 */
public class LaunchService extends IntentService {
    private static final String TAG = "LaunchService";
    private static final String ACTION_INIT_WHEN_APP_CREATE = "com.geolo.demo.launch.service.action.INIT";

    public static void start(Context context) {
        Intent intent = new Intent(context, LaunchService.class);
        intent.setAction(ACTION_INIT_WHEN_APP_CREATE);
        context.startService(intent);
    }

    public LaunchService() {
        this(TAG);
    }

    public LaunchService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_INIT_WHEN_APP_CREATE.equals(action)) {
                performInit();
            }
        }
    }

    /** 这里进行一些耗时性的初始化,需要注意某些初始化的操作不能在子线程中执行。*/
    private void performInit() {
        Log.e(TAG, "*** 初始化 performInit begin  ***");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "*** 初始化 performInit end ***");
    }
}
