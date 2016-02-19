package com.gzk.sample.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gzk.sample.R;

public class DialogTestActivity extends AppCompatActivity {
    private static final String TAG = DialogTestActivity.class.getSimpleName();
    private TextView btnDialog;

    private Dialog mDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_test);

        btnDialog = (TextView) findViewById(R.id.btndiaolog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog = createDialog();
                mDialog.show();
            }
        });
        Log.e(TAG, "onCreate ");
        if (savedInstanceState != null) {
            String ori = savedInstanceState.getString("test");
            Log.e(TAG,"onCreate  ori:"+ori);
            if(!TextUtils.isEmpty(ori)&&ori.equals("ssss")){
                mDialog = createDialog();
                mDialog.show();
            }
        }


    }


    private Dialog createDialog() {
        if (mDialog == null) {
            mDialog = new AlertDialog.Builder(this).
                    setTitle("test").
                    setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).
                    setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.e(TAG, "mDialog  sdadadada");
                        }
                    }).
                    create();
        }

        mDialog.setCanceledOnTouchOutside(false);
        return mDialog;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {


        if (mDialog != null&&mDialog.isShowing()) {
            outState.putString("test", "ssss");
        }else{
            outState.putString("test", "");
        }
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop ");
/*
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy ");
    }
}
