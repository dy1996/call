package com.example.administrator.myapp;

import android.app.ListActivity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

public class QueryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_query);
        this.setTitle("查询学生信息");
        final myHelper helper=new myHelper(this);
        Cursor c=helper.query();
        String[] s={"_id","banji","sno","sname"};
        int[] t={R.id.text1,R.id.text2,R.id.text3,R.id.text4};
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.activity_query,c,s,t);
        ListView listView=getListView();
        listView.setAdapter(adapter);
    }
}
