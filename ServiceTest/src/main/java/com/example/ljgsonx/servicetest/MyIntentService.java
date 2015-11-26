package com.example.ljgsonx.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by ljgsonx on 2015/11/14.
 */
public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super("=============");
    }

    public MyIntentService(){
        super("=============");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        long endTime = System.currentTimeMillis() + 5*1000;
        while (System.currentTimeMillis() < endTime){
            synchronized (this){
                try{
                    wait(endTime - System.currentTimeMillis());
                    //可以看出执行时间的误差
                    Log.i("--->", (endTime - System.currentTimeMillis()) + "");
                } catch (Exception e){
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        Log.i("--->", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        Log.i("--->", "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("--->", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("--->", "onBind");
        Log.i("--->",super.onBind(intent).toString());
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("--->", "onUnbind");
        return super.onUnbind(intent);
    }
}
