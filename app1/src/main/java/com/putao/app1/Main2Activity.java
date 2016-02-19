package com.putao.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = Main2Activity.class.getSimpleName();
    private TextView tvText;

    private String mPaakege;
    private String mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getData();

        initView();
    }

    private void getData() {
        Intent intent = this.getIntent();
        mPaakege = intent.getStringExtra("key1");
        mActivity = intent.getStringExtra("key2");
        Log.e("log", "mPaakege:" + mPaakege);
        Log.e("log", "mActivity:" + mActivity);
    }

    private void initView() {
        tvText = (TextView)findViewById(R.id.text2);

        tvText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text2:
                finishActivity();
                break;
            default:
                break;
        }
    }

    private void finishActivity(){
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putString("aa","dfsfdsfdsfsdf");
        i.putExtras(b);
        setResult(RESULT_OK,i);
        Main2Activity.this.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            finishActivity();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
