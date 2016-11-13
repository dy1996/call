package com.example.administrator.myapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    private Button add,back;
    private EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.setTitle("添加学生信息");

        et1=(EditText)findViewById(R.id.et_add_banji);
        et2= (EditText) findViewById(R.id.et_add_xuehao);
        et3= (EditText) findViewById(R.id.et_add_name);
        add= (Button) findViewById(R.id.button_add_sure);
        back= (Button) findViewById(R.id.button_add_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入的文本信息
                String banji=et1.getText().toString();
                String sno=et2.getText().toString();
                String sname=et3.getText().toString();
                //创建Contentvalues对象，封装记录信息
                ContentValues values=new ContentValues();
                values.put("banji",banji);
                values.put("sno",sno);
                values.put("sname",sname);

                //创建数据库工具类
                myHelper helper=new myHelper(getApplicationContext());
                //调用insert方法插入数据
                helper.insert(values);
                Toast.makeText(getApplicationContext(),"添加成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

