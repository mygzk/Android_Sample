package com.gzk.sample.activity;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gzk.sample.R;

public class DialogActivity extends AppCompatActivity {

    private MyDialog mDialog;
    private String mMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
        button.setText("CLICK");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDialog.show();

            }
        });
        setContentView(button);



        String message = "default";
        if (savedInstanceState != null) {
            message = savedInstanceState.getString("message");
        }
        mDialog = new MyDialog.Builder(DialogActivity.this)
                .setMessage(message)
                .setListener(new MyDialog.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogActivity.this, "onClick", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
        mDialog.show();



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("message", mDialog.getMessage());
    }

    public static class MyDialog extends Dialog {


        public interface OnClickListener {
            void onClick(View v);
        }

        private OnClickListener mListener;
        private String mMessage;

        private EditText etMessage;



        public MyDialog(Context context) {
            super(context);
            View v = LayoutInflater.from(context).inflate(R.layout.dialog, null, false);
            etMessage = (EditText) v.findViewById(R.id.tv_message);
            etMessage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(v);
                }
            });
            addContentView(v, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }

        public void setListener(OnClickListener listener) {
            this.mListener = listener;
        }

        public String getMessage() {
            return etMessage.getEditableText().toString();
        }

        public void setMessage(String message) {
            this.etMessage.setText(message);
        }


        public static class Builder {

            private final Context mContext;
            private String mMessage;
            private OnClickListener mListener;

            public Builder(Context context) {
                mContext = context;
            }

            public Builder setMessage(String message) {
                mMessage = message;
                return this;
            }

            public Builder setListener(OnClickListener listener) {
                mListener = listener;
                return this;
            }

            public MyDialog build() {
                MyDialog dialog = new MyDialog(mContext);
                dialog.setListener(mListener);
                dialog.setMessage(mMessage);
                return dialog;
            }
        }

    }


}
