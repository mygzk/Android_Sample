package com.gzk.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gzk.sample.activity.Main2Activity;
import com.gzk.sample.adapter.MyActivityAdapter;
import com.gzk.sample.model.MyActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView activityListView;
    private ArrayList<MyActivity> listDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        activityListView = (ListView)findViewById(R.id.list_activity);
        listDate = new ArrayList<>();
        listDate.add(new MyActivity(Main2Activity.class,"Main2Activity"));
        activityListView.setAdapter(new MyActivityAdapter(MainActivity.this,listDate));
        activityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyActivity myActivityItem = listDate.get(position);
                Intent activityIntent = new Intent(MainActivity.this,myActivityItem.getMyClassActivity());
                startActivity(activityIntent);
            }
        });
    }
}
