package com.example.ljgsonx.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ljgsonx on 2015/11/14.
 */
public class MyService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("--->", "onDestroy");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("--->", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("--->", "onStartCommand");
        Log.i("--->", super.onStartCommand(intent, flags, startId) + "---]");
        Log.i("--->", flags+"---]");
        Log.i("--->", START_NOT_STICKY+"---"+START_STICKY+"---"+START_REDELIVER_INTENT+"]");
        return super.onStartCommand(intent, flags, startId);
    }
}
