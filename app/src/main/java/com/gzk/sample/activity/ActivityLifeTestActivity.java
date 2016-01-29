package com.gzk.sample.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gzk.sample.MainActivity;
import com.gzk.sample.R;

public class ActivityLifeTestActivity extends AppCompatActivity {

    private static final String TAG = ActivityLifeTestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_life_test);
        Log.e(TAG, "activity life:onCreate");

        findViewById(R.id.activityLifeBackBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ActivityLifeTestActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "activity life:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "activity life:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "activity life:onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "activity life:onDestroy");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "activity life:onNewIntent");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.e(TAG, "activity life:onSaveInstanceState");
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG, "activity life:onConfigurationChanged");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "activity life:onRestoreInstanceState");
    }
}
