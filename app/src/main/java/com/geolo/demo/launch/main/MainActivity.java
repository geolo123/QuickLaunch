package com.geolo.demo.launch.main;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.geolo.demo.launch.BaseActivity;
import com.geolo.demo.launch.R;

/**
 * @author Created by jwb on 2017/4/1.
 */

public class MainActivity extends BaseActivity {

    private final static String TAG = "MainActivity";
    private String mCurrentFragmentTag = MainFragment.TAG;
    private FragmentManager mFragmentManager;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void todoStart(Bundle savedInstanceState) {
        Log.e(TAG, "*** MainActivity 开始做自己的逻辑任务了");
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home, MainFragment.newInstance(), mCurrentFragmentTag)
            .commitAllowingStateLoss();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "*** MainActivity onResume() 生命周期被破坏，请使用Fragment !");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "*** MainActivity onStart() 生命周期被破坏，请使用Fragment !");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "*** MainActivity onRestart() 生命周期被破坏，请使用Fragment !");
    }

}
