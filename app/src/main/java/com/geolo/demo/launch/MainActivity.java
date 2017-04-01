package com.geolo.demo.launch;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author Created by jwb on 2017/4/1.
 */

public class MainActivity extends BaseActivity {

    private final static String TAG = "MainActivity";

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void todoStart(Bundle savedInstanceState) {
        Log.e(TAG, "MainActivity 开始做自己的逻辑任务了");
    }

}
