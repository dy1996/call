package com.example.administrator.myapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button add;
    private Button del;
    private Button query;
    private Button call;
    private EditText et_add_class;
    private EditText et_add_number;
    private EditText et_add_name;
    myHelper helper;
   // List data=new ArrayList<Object>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=(Button)findViewById(R.id.button_tianjia);
        del=(Button)findViewById(R.id.button_shanchu);
        query=(Button)findViewById(R.id.button_chaxun);
        call=(Button)findViewById(R.id.button_dianming);
        et_add_class=(EditText)findViewById(R.id.et_add_banji);
        et_add_number=(EditText)findViewById(R.id.et_add_xuehao);
        et_add_name=(EditText)findViewById(R.id.et_add_name);
        add.setOnClickListener(this);
        del.setOnClickListener(this);
        query.setOnClickListener(this);
        call.setOnClickListener(this);
    }
//    public void OnClick1(View v){
//        SQLiteDatabase db=helper.getWritableDatabase();
//        db.execSQL("insert into STUDENT(class,number,name)values(?,?,?)",new Object[]{et_add_class,et_add_number,et_add_name});
//        db.close();
//        Toast.makeText(getApplicationContext(),"添加成功",Toast.LENGTH_LONG).show();
//    }
//    public void OnClick2(View v){
//        SQLiteDatabase db=helper.getWritableDatabase();
//        db.execSQL("delete from STUDENT(class,number,name)values(?,?,?)",new Object[]{});
//        db.close();
//        Toast.makeText(getApplicationContext(),"删除成功",Toast.LENGTH_LONG).show();
//    }
//    public void OnClick3(View v){
//        SQLiteDatabase db=helper.getWritableDatabase();
//        Cursor cursor=db.rawQuery("select * from STUDENT",null);
//        if(cursor!=null&&cursor.getCount()>0){
//            cursor.moveToNext();
//        }
//        db.close();
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_tianjia:
                Intent intent1=new Intent(getApplicationContext(),AddActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_shanchu:
                Intent intent2=new Intent(getApplicationContext(),DelActivity.class);
                startActivity(intent2);
                break;
            case R.id.button_chaxun:
                Intent intent3=new Intent(getApplicationContext(),QueryActivity.class);
                startActivity(intent3);
                break;
            case R.id.button_dianming:
                Intent intent4=new Intent(getApplicationContext(),CallActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
