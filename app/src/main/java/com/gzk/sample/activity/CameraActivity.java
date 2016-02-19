package com.gzk.sample.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gzk.sample.R;
import com.gzk.sample.fragment.TestFragment;
import com.gzk.sample.util.PicSelectedUtil;

public class CameraActivity extends AppCompatActivity {

    private static final String TAG = CameraActivity.class.getSimpleName();


    private Button btnTakeCamera;
    private Uri mPhotoUri = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        if (savedInstanceState != null) {
           // Log.e(TAG, "onCreate savedInstanceState:" + savedInstanceState.toString());
            Log.e(TAG, "onCreate savedInstanceState:" + savedInstanceState.getString("uri","ssss"));
        }

        getFragmentManager().beginTransaction().replace(R.id.container, TestFragment.newInstance()).commit();


        btnTakeCamera = (Button) findViewById(R.id.takecamera);
        btnTakeCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPhotoUri = PicSelectedUtil.doTakePhoto(CameraActivity.this,
                        CameraActivity.this,
                        PicSelectedUtil.requestcode_camera);
            }
        });


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e(TAG, "requestCode:" + requestCode);
        Log.e(TAG, "resultCode:" + resultCode);
        Log.e(TAG, "data:" + data.toString());
        Log.e(TAG, "mPhotoUri:" + mPhotoUri);


    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        if (mPhotoUri != null) {
            outPersistentState.putString("uri", mPhotoUri.toString());
        }
        super.onSaveInstanceState(outState, outPersistentState);


    }
}
