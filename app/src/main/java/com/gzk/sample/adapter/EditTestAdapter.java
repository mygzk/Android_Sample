package com.gzk.sample.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.gzk.sample.R;
import com.gzk.sample.model.MyActivity;

import java.util.List;

/**
 * Created by gzhenk on 16-1-25.
 */
public class EditTestAdapter extends BaseAdapter {
    private List<String> listData;
    private LayoutInflater mInflater;

    public EditTestAdapter(Context context, List<String> listData) {
        this.listData = listData;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.e("getView", "getView position:" + position);
        HolderView holderView = null;
        if (convertView == null) {
            holderView = new HolderView();
            convertView = mInflater.inflate(R.layout.list_item_edittest, null);
            holderView.etTest = (EditText) convertView.findViewById(R.id.list_item_edittest);
            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }

        holderView.etTest.setText("" + listData.get(position));


        holderView.etTest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("afterTextChanged", "afterTextChanged s:" + s);
                Log.e("afterTextChanged", "afterTextChanged position:" + position);
            }
        });
        return convertView;
    }

    static class HolderView {
        EditText etTest;
    }


}
