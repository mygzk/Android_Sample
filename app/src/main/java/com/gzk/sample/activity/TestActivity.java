package com.gzk.sample.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gzk.sample.R;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = TestActivity.class.getSimpleName();

    private Button btnTest1;
    private Button btnTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        btnTest1 = (Button) findViewById(R.id.btnTest1);
        btnTest2 = (Button) findViewById(R.id.btnTest2);

        btnTest1.setOnClickListener(this);
        btnTest2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTest1:
                otherApp();
                break;
            case R.id.btnTest2:
            default:
                break;
        }
    }


    private void otherApp() {
        ComponentName componetName = new ComponentName("com.putao.app1", "com.putao.app1.Main2Activity");
        try {

            Intent intent = new Intent();
            intent.setComponent(componetName);
            intent.putExtra("key1", "com.gzk.sample");
            intent.putExtra("key2", "com.gzk.sample.TestActivity");
            startActivityForResult(intent, 100);
        } catch (Exception e) {
            Log.e("log", "　跳转失败");
            e.printStackTrace();
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult requestCode:" + requestCode);
        Log.e(TAG, "onActivityResult resultCode:" + resultCode);
        Log.e(TAG,"onActivityResult data:"+data);
        if(data!=null){
            Log.e(TAG,"onActivityResult data11:"+data.getData());
        }
    }
}
