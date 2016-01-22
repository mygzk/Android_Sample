package com.gzk.sample.adapter;

import android.content.Context;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gzk.sample.R;
import com.gzk.sample.model.MyActivity;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by gzhenk on 16-1-22.
 */
public class MyActivityAdapter extends BaseAdapter {

    private List<MyActivity> listData;
    private LayoutInflater mInflater;

    public MyActivityAdapter(Context context, List<MyActivity> listData) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView = null;
        if (convertView == null) {
            holderView = new HolderView();
            convertView = mInflater.inflate(R.layout.list_item_activity, null);
            holderView.tvMyClass = (TextView) convertView.findViewById(R.id.list_item_activity_text);
            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }

        holderView.tvMyClass.setText("" + listData.get(position).getDecriptionText());
        return convertView;
    }

    static class HolderView {
        TextView tvMyClass;
    }
}
