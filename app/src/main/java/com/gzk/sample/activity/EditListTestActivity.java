package com.gzk.sample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.gzk.sample.R;
import com.gzk.sample.adapter.EditTestAdapter;

import java.util.ArrayList;
import java.util.List;

public class EditListTestActivity extends AppCompatActivity {
    private ListView editListview;

    private List<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initView();
    }

    private void initView() {
        editListview = (ListView) findViewById(R.id.test_list_editText);
        listData = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            listData.add("sssss-" + i);
        }


        editListview.setAdapter(new EditTestAdapter(EditListTestActivity.this, listData));

    }
}
