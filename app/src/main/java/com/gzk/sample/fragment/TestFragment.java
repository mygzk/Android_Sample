package com.gzk.sample.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.gzk.sample.R;

public class TestFragment extends Fragment {
    private static final String TAG = TestFragment.class.getSimpleName();
    private static final String TAG1 = TestFragment.class.getSimpleName() + "-01";

    private static final String ImgURl = "imgurl";


    private Button btnCamera;
    private int requestcodeCamera = 100;
    private Uri mPhotoUri = null;

    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public TestFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.e(TAG, "===onCreate===");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            if (!TextUtils.isEmpty(savedInstanceState.getString(ImgURl, null))) {

                mPhotoUri = Uri.parse(savedInstanceState.getString(ImgURl, null));
            }
            Log.e(TAG, "onViewCreated savedInstanceState:" + savedInstanceState.toString());
        }


        Log.e(TAG, "onViewCreated mPhotoUri:" + (mPhotoUri + "").toString());

        btnCamera = (Button) view.findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mPhotoUri = doTakePhoto(getActivity(),
                        TestFragment.this,
                        requestcodeCamera);

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG + "1", "onActivityResult requestCode:" + requestCode);
        Log.e(TAG + "1", "onActivityResult resultCode:" + resultCode);
        Log.e(TAG + "1", "onActivityResult data:" + data);
        Log.e(TAG + "1", "onActivityResult mPhotoUri:" + mPhotoUri);
        if (resultCode == -1) {

        }
    }


    public static Uri doTakePhoto(Context context, Object obj, int requestCode) {
        Uri mPhotoUri = null;
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(context, "存储卡不可用", Toast.LENGTH_SHORT).show();
            return mPhotoUri;
        }
        //  String filePath = FileUtil.getAccountImageTempFolder() + File.separator + FileUtil.getImgName();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            ContentValues contentValues = new ContentValues(1);
            //contentValues.put(MediaStore.Images.Media.DATA, filePath);
            contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/*");
            mPhotoUri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    contentValues);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mPhotoUri);
            if (obj instanceof Activity) {
                ((Activity) obj).startActivityForResult(intent, requestCode);
            } else if (obj instanceof Fragment) {
                ((Fragment) obj).startActivityForResult(intent, requestCode);
            } else {
                ((Activity) context).startActivityForResult(intent, requestCode);
            }
        }
        return mPhotoUri;
    }

/*
    @Override
    public void onPause() {
        Log.e(TAG, "===onPause===");
        Log.e(TAG1, "=TAG1==onPause===");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e(TAG, "===onStop===");
        Log.e(TAG1, "==TAG1=onStop===");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "===onDestroy===");
        super.onDestroy();
    }*/

    @Override
    public void onSaveInstanceState(Bundle outState) {
//        Log.e(TAG, "===onSaveInstanceState===");
        Log.e(TAG, "===onSaveInstanceState=mPhotoUri:" + mPhotoUri);
        super.onSaveInstanceState(outState);
        outState.putString(ImgURl, mPhotoUri + "");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e(TAG, "===onConfigurationChanged===");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.e(TAG, "===onViewStateRestored===");
        super.onViewStateRestored(savedInstanceState);


    }


}
