package com.gzk.sample.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gzk.sample.R;
import com.gzk.sample.service.ServiceTest;

public class ServiceTestActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ServiceTestActivity.class.getSimpleName();

    private Button btnStartService;
    private Button btnStopService;
    private Button btnBindService;
    private Button btnUnbindService;


    private ServiceTest mServiceTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);

        initView();
    }

    private void initView() {
        btnStartService = (Button) findViewById(R.id.servicetest_btn1);
        btnStartService.setOnClickListener(this);

        btnStopService = (Button) findViewById(R.id.servicetest_btn2);
        btnStopService.setOnClickListener(this);

        btnBindService = (Button) findViewById(R.id.servicetest_btn3);
        btnBindService.setOnClickListener(this);

        btnUnbindService = (Button) findViewById(R.id.servicetest_btn4);
        btnUnbindService.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.servicetest_btn1:
                startService();
                break;
            case R.id.servicetest_btn2:
                stopService();
                break;
            case R.id.servicetest_btn3:
                bindService();
                break;
            case R.id.servicetest_btn4:
                unBindService();
                break;

            default:
                break;
        }
    }

    Intent intentService;

    private void startService() {
        intentService = new Intent(ServiceTestActivity.this, ServiceTest.class);
        intentService.putExtra("startService","startService");
        startService(intentService);
    }

    private void stopService() {
        if (intentService != null) {
            stopService(intentService);
        }
    }

    private void bindService() {
        Intent intentService = new Intent(ServiceTestActivity.this, ServiceTest.class);
        intentService.putExtra("bindService","bindService");
        bindService(intentService, mServiceConnection, BIND_AUTO_CREATE);
    }

    private void unBindService() {
        if (mServiceConnection != null) {
            unbindService(mServiceConnection);
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "ServiceConnection name:" + name.toString());
            mServiceTest = ((ServiceTest.MyBinder) service).getServiceTest();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceTest = null;
        }
    };
}
