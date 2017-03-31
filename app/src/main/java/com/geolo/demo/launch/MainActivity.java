package com.geolo.demo.launch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geolo.demo.launch.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);// 将主题切换回app的主题
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
