package com.geolo.demo.launch.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geolo.demo.launch.R;

/**
 * @author Created by jwb on 2017/4/5.
 */

public class MainFragment extends Fragment {

    public final static String TAG = "MainFragment";

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "*** MainFragment onCreate() *** !");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "*** MainFragment onActivityCreated() *** !");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "*** MainFragment onResume() *** !");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "*** MainFragment onStart() *** !");
    }

}
