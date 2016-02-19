package com.gzk.sample.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class CalulateService extends Service {
    public CalulateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private final CalculateInterface.Stub mBinder = new CalculateInterface.Stub() {
        @Override
        public double doCalculate(double a, double b) throws RemoteException {
            return a + b;
        }
    };
}
