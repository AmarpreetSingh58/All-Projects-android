package com.amarpreetsinghprojects.jobscheduler;

import android.app.Application;
import android.util.Log;

/**
 * Created by kulvi on 07/26/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("","MyApplication, oncreate");
    }
}
