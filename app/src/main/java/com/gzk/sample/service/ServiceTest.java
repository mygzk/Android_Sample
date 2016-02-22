package com.gzk.sample.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.nfc.Tag;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ServiceTest extends Service {

    private static final String TAG = ServiceTest.class.getSimpleName();

    public ServiceTest() {
    }


    public class MyBinder extends Binder {
        public ServiceTest getServiceTest(){
            return ServiceTest.this;
        }

    }

    private MyBinder mMyBinder = new MyBinder();


    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "=====onBind==");
        return mMyBinder;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        Log.e(TAG, "=====onCreate==");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e(TAG, "=====onStart==");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "=====onStartCommand==");
        Log.e(TAG, "=====onStartCommand=intent="+intent.getData());
        Log.e(TAG, "=====onStartCommand=flags="+flags);
        Log.e(TAG, "=====onStartCommand=startId="+startId);
        return super.onStartCommand(intent, flags, startId);

    }


    @Override
    public void unbindService(ServiceConnection conn) {
        Log.e(TAG, "=====unbindService==");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "=====onDestroy==");
        super.onDestroy();
    }
}
