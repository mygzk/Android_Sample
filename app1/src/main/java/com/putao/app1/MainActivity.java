package com.putao.app1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gzk.sample.aidl.CalculateInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTest1;
    private Button btnTest2;
    private Button btnTest3;
    private Button btnTest4;

    private Messenger messenger;
    private Messenger reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        messageService();

    }


    private void aidlService() {
        Intent intent = new Intent();
        intent.setAction("com.gzk.sample.aidl.CalulateService");
        //intent.setAction("com.gzk.sample.service.MessengerTestService");
        intent.setPackage("com.gzk.sample");

        bindService(intent, mAidlConnection, Context.BIND_AUTO_CREATE);
    }


    private void messageService() {

        reply = new Messenger(handler);
        Intent intent = new Intent();
        intent.setAction("com.gzk.sample.service.MessengerTestService");
        intent.setPackage("com.gzk.sample");

        bindService(intent, mMessagerConnection, Context.BIND_AUTO_CREATE);
    }

    private void initView() {
        btnTest1 = (Button) findViewById(R.id.btnTest1);
        btnTest1.setOnClickListener(this);

        btnTest2 = (Button) findViewById(R.id.btnTest2);
        btnTest2.setOnClickListener(this);

        btnTest3 = (Button) findViewById(R.id.btnTest3);
        btnTest3.setOnClickListener(this);

        btnTest4 = (Button) findViewById(R.id.btnTest4);
        btnTest4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTest1:
                intentActivity(Main1Activity.class);
                break;
            case R.id.btnTest2:
                intentActivity(Main2Activity.class);
                break;
            case R.id.btnTest3:
                intentActivity(Main3Activity.class);
                break;
            case R.id.btnTest4:
              /*  try {
                    double result = mCalculateInterface.doCalculate(1,2);

                    Log.e("log","=mCalculateInterface====result:"+result);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }*/

                sendMessage();
                break;
            default:
                break;
        }
    }

    private void intentActivity(Class activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }


    //CalculateInterface mCalculateInterface;

    private CalculateInterface mCalculateInterface;

    private ServiceConnection mAidlConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {

            mCalculateInterface = CalculateInterface.Stub.asInterface(service);
        }

        public void onServiceDisconnected(ComponentName className) {
            mCalculateInterface = null;
        }
    };


///////////////////////////////////////////////////////////////////////////////////

    private ServiceConnection mMessagerConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            Log.e("log", "绑定成功");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    public void sendMessage() {
        Message msg = Message.obtain(null, 1);
        // 设置回调用的Messenger
        msg.replyTo = reply;
        try {
            messenger.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            Log.e("log", "回调成功");
        }

    };

///////////////////////////////////////////////////////////////////////////////////
}
