package com.example.administrator.myapp;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class DelActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_del);
        this.setTitle("删除学生信息");
        final myHelper help=new myHelper(this);
        Cursor c=help.query();


        //列表项数组
        String[] s={"_id","banji","sno","sname"};
        //列表项ID
        int[] t={R.id.text1,R.id.text2,R.id.text3,R.id.text4};
        //适配器
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.activity_del,c,s,t);
        //列表视图
        ListView listView=getListView();
        //为列表试图添加适配器
        listView.setAdapter(adapter);
        //提示对话框
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //设置listview单击监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final long temp=arg3;
                builder.setMessage("确认删除该记录吗？").setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //删除数据
                        help.del((int)temp);
                        //重新查询数据
                        Cursor c=help.query();
                        String[] s={"_id","banji","sno","sname"};
                        int[] t={R.id.text1,R.id.text2,R.id.text3,R.id.text4};

                        SimpleCursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),R.id.activity_del,c,s,t);
                        ListView listView=getListView();
                        listView.setAdapter(adapter);
                    }
                }).setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog ad=builder.create();
                ad.show();
            }
        });
        help.close();
    }

}
