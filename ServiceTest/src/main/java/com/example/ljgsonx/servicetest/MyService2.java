package com.example.ljgsonx.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ljgsonx on 2015/11/14.
 */
public class MyService2 extends Service{

    class MyBinder extends Binder{
        public void myWork() {
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.i("--->", "doing my work");
                }
            }.start();
            Log.i("--->", "done myWork");
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("--->", "onBind");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("--->", "onUnbind");
        return true;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.i("--->", "unbindService");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("--->", "onDestroy");
    }

    @Override
    public void onCreate() {

        Log.i("--->", "onCreate()");
        super.onCreate();
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
