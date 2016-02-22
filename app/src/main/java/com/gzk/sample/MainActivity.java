package com.gzk.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gzk.sample.activity.ActivityLifeTestActivity;
import com.gzk.sample.activity.CameraActivity;
import com.gzk.sample.activity.DialogActivity;
import com.gzk.sample.activity.DialogTestActivity;
import com.gzk.sample.activity.EditListTestActivity;
import com.gzk.sample.activity.Main2Activity;
import com.gzk.sample.activity.ServiceTestActivity;
import com.gzk.sample.activity.TestActivity;
import com.gzk.sample.adapter.MyActivityAdapter;
import com.gzk.sample.model.MyActivity;

import java.util.ArrayList;

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
        activityListView = (ListView) findViewById(R.id.list_activity);
        listDate = new ArrayList<>();
        listDate.add(new MyActivity(Main2Activity.class, "Main2Activity"));
        listDate.add(new MyActivity(EditListTestActivity.class, "EditListTestActivity"));
        listDate.add(new MyActivity(ActivityLifeTestActivity.class, "ActivityLifeTestActivity"));
        listDate.add(new MyActivity(DialogTestActivity.class, "DialogTestActivity"));
        listDate.add(new MyActivity(DialogActivity.class, "DialogActivity"));
        listDate.add(new MyActivity(CameraActivity.class, "CameraActivity"));
        listDate.add(new MyActivity(TestActivity.class, "TestActivity"));
        listDate.add(new MyActivity(ServiceTestActivity.class, "ServiceTestActivity"));


        activityListView.setAdapter(new MyActivityAdapter(MainActivity.this, listDate));
        activityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyActivity myActivityItem = listDate.get(position);
                Intent activityIntent = new Intent(MainActivity.this, myActivityItem.getMyClassActivity());
                startActivity(activityIntent);
            }
        });
    }
}
